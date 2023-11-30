package com.anup.betterERP.repository;

import com.anup.betterERP.Entity.superuser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface superuserRepository extends MongoRepository<superuser,String> {
    boolean existsByPassword(String password);
    boolean existsByName(String name);
}
