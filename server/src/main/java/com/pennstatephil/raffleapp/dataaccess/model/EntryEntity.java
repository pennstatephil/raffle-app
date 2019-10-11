package com.pennstatephil.raffleapp.dataaccess.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "entries")
@Data
@Builder
public class EntryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private PrizeEntity prize;
    private Integer tickets;
}
