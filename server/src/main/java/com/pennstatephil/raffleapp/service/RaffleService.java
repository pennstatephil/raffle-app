package com.pennstatephil.raffleapp.service;

import com.pennstatephil.raffleapp.dataaccess.model.EntryEntity;
import com.pennstatephil.raffleapp.dataaccess.model.RaffleEntity;
import com.pennstatephil.raffleapp.dataaccess.model.TierEntity;
import com.pennstatephil.raffleapp.dataaccess.repo.EntryRepository;
import com.pennstatephil.raffleapp.dataaccess.repo.RaffleRepository;
import com.pennstatephil.raffleapp.dataaccess.repo.TierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaffleService {
    private final RaffleRepository raffleRepository;
    private final EntryRepository entryRepository;
    private final TierRepository tierRepository;

    @Autowired
    public RaffleService(RaffleRepository raffleRepository, EntryRepository entryRepository, TierRepository tierRepository) {
        this.raffleRepository = raffleRepository;
        this.entryRepository = entryRepository;
        this.tierRepository = tierRepository;
    }

    public RaffleEntity getRaffleById(Long raffleId) {
        RaffleEntity foundEntity = raffleRepository.findById(raffleId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Raffle not found"));

        return foundEntity.toBuilder()
                .prizes(foundEntity.getPrizes().stream()
                        .map(prize -> prize.toBuilder().ticketsEntered(entryRepository.findAllByPrizeId(prize.getId()).stream()
                                .map(EntryEntity::getTickets).reduce(0, Integer::sum)).build())
                        .collect(Collectors.toList()))
                .build();
    }

    public Long getTicketsByAmount(Long raffleId, BigDecimal amount) {
        List<TierEntity> tiers = tierRepository.getTiersByRaffleIdOrderByAmountDesc(raffleId);
        long totalTickets = 0;

        for (TierEntity tier : tiers) {
            BigDecimal result = amount.divideToIntegralValue(tier.getAmount());
            if (result.compareTo(BigDecimal.ZERO) > 0) {
                totalTickets += result.multiply(BigDecimal.valueOf(tier.getTickets())).toBigInteger().longValue();
                amount = amount.subtract(result.multiply(tier.getAmount()));
            }
        }

        return totalTickets;
    }
}
