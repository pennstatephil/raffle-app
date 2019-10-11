package com.pennstatephil.raffleapp.dataaccess.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "prizes")
@Data
@Builder
public class PrizeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private String imageUrl;
    @ManyToOne
    private RaffleEntity raffle;
    @OneToOne
    private UserEntity wonBy;
}
