package com.pennstatephil.raffleapp.dataaccess.repo;

import com.pennstatephil.raffleapp.dataaccess.model.EntryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends CrudRepository<EntryEntity, Long> {
}
