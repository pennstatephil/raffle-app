package com.pennstatephil.raffleapp.dataaccess.repo;

import com.pennstatephil.raffleapp.dataaccess.model.DonationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends CrudRepository<DonationEntity, Long> {
}
