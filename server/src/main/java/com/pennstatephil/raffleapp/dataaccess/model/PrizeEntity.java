package com.pennstatephil.raffleapp.dataaccess.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "prizes")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PrizeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private String imageUrl;
    @Transient
    private Integer ticketsEntered;
    @ManyToOne
    @JsonIgnore
    private RaffleEntity raffle;
    @OneToOne
    @JoinColumn(name = "won_by")
    private UserEntity wonBy;
}
