package com.anup.betterERP.repository;

import com.anup.betterERP.Entity.badLoginLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface badLoginLogRepo extends MongoRepository<badLoginLog,String> {
}
