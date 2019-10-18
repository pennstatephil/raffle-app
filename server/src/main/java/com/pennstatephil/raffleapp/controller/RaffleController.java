package com.pennstatephil.raffleapp.controller;

import com.pennstatephil.raffleapp.dataaccess.model.RaffleEntity;
import com.pennstatephil.raffleapp.model.RaffleEntryRequest;
import com.pennstatephil.raffleapp.service.RaffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/raffles")
public class RaffleController {
    private final RaffleService raffleService;

    @Autowired
    public RaffleController(RaffleService raffleService) {
        this.raffleService = raffleService;
    }

    @GetMapping("/{id}")
    public RaffleEntity getRaffleById(@PathVariable("id") Long raffleId) {
        return raffleService.getRaffleById(raffleId);
    }

    @GetMapping("/{id}/tickets/{amount}")
    public Integer getTicketsByAmount(@PathVariable("id") Long raffleId, @PathVariable("amount") BigDecimal amount) {
        return raffleService.getTicketsByAmount(raffleId, amount);
    }

    @PostMapping("/{id}/entry")
    public void createEntry(@PathVariable("id") Long raffleId, @Valid @RequestBody RaffleEntryRequest request) {
        raffleService.createRaffleEntry(raffleId, request);
    }

    @PostMapping("/{id}/winners")
    public RaffleEntity getWinners(@PathVariable("id") Long raffleId) {
        return raffleService.pickWinners(raffleId);
    }
}
