package com.pennstatephil.raffleapp.dataaccess.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "entries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
