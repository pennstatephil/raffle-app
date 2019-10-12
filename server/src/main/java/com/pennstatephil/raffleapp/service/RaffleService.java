package com.pennstatephil.raffleapp.service;

import com.pennstatephil.raffleapp.dataaccess.model.EntryEntity;
import com.pennstatephil.raffleapp.dataaccess.model.RaffleEntity;
import com.pennstatephil.raffleapp.dataaccess.repo.EntryRepository;
import com.pennstatephil.raffleapp.dataaccess.repo.RaffleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
public class RaffleService {
    private final RaffleRepository raffleRepository;
    private final EntryRepository entryRepository;

    @Autowired
    public RaffleService(RaffleRepository raffleRepository, EntryRepository entryRepository) {
        this.raffleRepository = raffleRepository;
        this.entryRepository = entryRepository;
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
}
