package com.pennstatephil.raffleapp.dataaccess.repo;

import com.pennstatephil.raffleapp.dataaccess.model.RaffleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaffleRepository extends CrudRepository<RaffleEntity, Long> {
}
