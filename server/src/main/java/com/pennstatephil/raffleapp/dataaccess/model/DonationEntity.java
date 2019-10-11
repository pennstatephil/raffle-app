package com.pennstatephil.raffleapp.dataaccess.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "donations")
@Data
@Builder
public class DonationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
//    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
//    @JoinColumn(name = "raffle_id")
    private RaffleEntity raffle;
    @NotNull
    @DecimalMin(value = "0.00", inclusive = false)
    private BigDecimal amount;
}
