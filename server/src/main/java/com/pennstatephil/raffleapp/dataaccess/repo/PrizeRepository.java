package com.pennstatephil.raffleapp.dataaccess.repo;

import com.pennstatephil.raffleapp.dataaccess.model.PrizeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeRepository extends CrudRepository<PrizeEntity, Long> {
}
