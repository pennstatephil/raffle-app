package com.pennstatephil.raffleapp.dataaccess.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tiers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TierEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = RaffleEntity.class)
    @JsonIgnore
    private RaffleEntity raffle;
    private BigDecimal amount;
    private Integer tickets;
}
