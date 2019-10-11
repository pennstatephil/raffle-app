package com.pennstatephil.raffleapp.dataaccess.repo;

import com.pennstatephil.raffleapp.dataaccess.model.TierEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TierRepository extends CrudRepository<TierEntity, Long> {
    List<TierEntity> getTiersByRaffleIdOrderByAmountDesc(Long raffleId);
}
