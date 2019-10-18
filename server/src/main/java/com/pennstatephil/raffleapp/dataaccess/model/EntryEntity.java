package com.pennstatephil.raffleapp.dataaccess.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entries")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private PrizeEntity prize;
    @Min(1)
    @NotNull
    private Integer tickets;
}
