package com.pennstatephil.raffleapp.dataaccess.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "raffles")
@Data
@Builder
public class RaffleEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @ManyToOne
    private UserEntity createdBy;

    private Boolean active;
    private Instant startsAt;
    private Instant endsAt;

    @OneToMany
    private List<PrizeEntity> prizes;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
