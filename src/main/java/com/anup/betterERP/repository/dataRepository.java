package com.anup.betterERP.repository;

import com.anup.betterERP.Entity.studentData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface dataRepository extends MongoRepository<studentData,String> {
    studentData findByVchRollNo(String vchRollNo);
    List<studentData> findByVchNameLike(String name);
}
