package com.anup.betterERP.repository;

import com.anup.betterERP.Entity.logs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface logRepository extends MongoRepository<logs,String> {

}
