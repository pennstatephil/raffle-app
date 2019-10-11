package com.pennstatephil.raffleapp.dataaccess.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tiers")
@Data
@Builder
public class TierEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private RaffleEntity raffle;
    private BigDecimal amount;
    private Integer tickets;
}
