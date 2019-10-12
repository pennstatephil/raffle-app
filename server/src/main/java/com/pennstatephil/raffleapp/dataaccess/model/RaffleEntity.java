package com.pennstatephil.raffleapp.dataaccess.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "raffles")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RaffleEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    private Boolean active;
    private Instant startsAt;
    private Instant endsAt;

    @OneToMany(mappedBy = "raffle")
    private List<PrizeEntity> prizes;

    @OneToMany(mappedBy = "raffle")
    private List<TierEntity> tiers;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
