package com.pennstatephil.raffleapp.dataaccess.repo;

import com.pennstatephil.raffleapp.dataaccess.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
}
