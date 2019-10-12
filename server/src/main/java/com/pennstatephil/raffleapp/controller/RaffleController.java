package com.pennstatephil.raffleapp.controller;

import com.pennstatephil.raffleapp.dataaccess.model.RaffleEntity;
import com.pennstatephil.raffleapp.service.RaffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Long getTicketsByAmount(@PathVariable("id") Long raffleId, @PathVariable("amount") BigDecimal amount) {
        return raffleService.getTicketsByAmount(raffleId, amount);
    }
}
