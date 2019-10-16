package com.pennstatephil.raffleapp.service;

import com.pennstatephil.raffleapp.dataaccess.model.*;
import com.pennstatephil.raffleapp.dataaccess.repo.*;
import com.pennstatephil.raffleapp.model.RaffleEntryRequest;
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
    private final UserRepo userRepo;
    private final DonationRepository donationRepository;
    private final PrizeRepository prizeRepository;

    @Autowired
    public RaffleService(RaffleRepository raffleRepository, EntryRepository entryRepository, TierRepository tierRepository, UserRepo userRepo, DonationRepository donationRepository, PrizeRepository prizeRepository) {
        this.raffleRepository = raffleRepository;
        this.entryRepository = entryRepository;
        this.tierRepository = tierRepository;
        this.userRepo = userRepo;
        this.donationRepository = donationRepository;
        this.prizeRepository = prizeRepository;
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

    public Integer getTicketsByAmount(Long raffleId, BigDecimal amount) {
        List<TierEntity> tiers = tierRepository.getTiersByRaffleIdOrderByAmountDesc(raffleId);
        int totalTickets = 0;

        for (TierEntity tier : tiers) {
            BigDecimal result = amount.divideToIntegralValue(tier.getAmount());
            if (result.compareTo(BigDecimal.ZERO) > 0) {
                totalTickets += result.multiply(BigDecimal.valueOf(tier.getTickets())).toBigInteger().intValue();
                amount = amount.subtract(result.multiply(tier.getAmount()));
            }
        }

        return totalTickets;
    }

    public void createRaffleEntry(Long raffleId, RaffleEntryRequest request) {
        Integer maxTickets = getTicketsByAmount(raffleId, request.getDonation().getAmount());
        Integer actualTickets = request.getEntries().stream().map(EntryEntity::getTickets).reduce(0, Integer::sum);
        if(maxTickets.compareTo(actualTickets) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exceeded maximum tickets");
        }

        UserEntity savedUser = userRepo.findByEmail(request.getUser().getEmail())
                .orElseGet(() -> userRepo.save(request.getUser().toBuilder().admin(false).build()));

        donationRepository.save(request.getDonation().toBuilder().raffle(raffleRepository.findById(raffleId).get()).user(savedUser).build());
        entryRepository.saveAll(request.getEntries().stream()
                .map(entry -> entry.toBuilder().prize(prizeRepository.findById(entry.getPrize().getId()).get())
                        .user(savedUser).build()).collect(Collectors.toList()));
    }
}
