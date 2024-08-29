package com.anup.betterERP.repository;

import com.anup.betterERP.Entity.Superuser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface superuserRepository extends MongoRepository<Superuser,String> {
    boolean existsByPassword(String password);
    boolean existsByName(String name);
}
