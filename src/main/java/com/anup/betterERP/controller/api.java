package com.anup.betterERP.controller;

import com.anup.betterERP.Entity.badLoginLog;
import com.anup.betterERP.Entity.logs;
import com.anup.betterERP.Entity.superuser;
import com.anup.betterERP.repository.badLoginLogRepo;
import com.anup.betterERP.repository.dataRepository;
import com.anup.betterERP.repository.logRepository;
import com.anup.betterERP.repository.superuserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anup.betterERP.Entity.studentData;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin("*")
public class api {
    @Autowired
    private dataRepository dataRepository;

    @Autowired
    private superuserRepository superuserRepository;

    @Autowired
    private badLoginLogRepo badLoginLogRepo;

    @Autowired
    private logRepository logRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/student/{action}/{urldata}")
    public ResponseEntity<?> getStudentData(@PathVariable("urldata") String urldata,
                                            @PathVariable("action") String action,
                                            @RequestParam(name = "password") String password,
                                            @RequestParam(name = "name") String name,
                                            HttpServletRequest request
                                            ){

        List<studentData> studentData=null;
        Query query = new Query();

        ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
        LocalDateTime indiaDateTime = LocalDateTime.now(indiaZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = indiaDateTime.format(formatter);

        if(superuserRepository.existsByName(name) && superuserRepository.existsByPassword(password))
        {
            logRepository.save(new logs(
                    request.getRemoteAddr(),
                    name,
                    timestamp,
                    action,
                    urldata
            ));

            if(action.equalsIgnoreCase("rollno"))
            {
                query.addCriteria(Criteria.where("vchRollNo").is(urldata.toUpperCase()));
                studentData = mongoTemplate.find(query, studentData.class);
            }
            else if (action.equalsIgnoreCase("name"))
            {
                studentData= dataRepository.findByVchNameLike(urldata.toUpperCase());
            }
            else if (action.equalsIgnoreCase("number"))
            {
                query.addCriteria(Criteria.where("vchContactNo").is(urldata));
                studentData = mongoTemplate.find(query, studentData.class);
            }
            else if (action.equalsIgnoreCase("fnumber"))
            {
                query.addCriteria(Criteria.where("vchFathersMobileNo").is(urldata));
                studentData = mongoTemplate.find(query, studentData.class);
            }
            else if (action.equalsIgnoreCase("registrationno"))
            {
                query.addCriteria(Criteria.where("vchRegistrationNo").is(urldata));
                studentData = mongoTemplate.find(query, studentData.class);
            }
        }
        else {
            badLoginLogRepo.save(new badLoginLog(
                    request.getRemoteAddr(),
                    name,
                    password,
                    timestamp,
                    action,
                    urldata
            ));
            return ResponseEntity.ok("{\"message\":\"Bad Crendential\"}");
        }
        return ResponseEntity.ok(studentData);
    }


    @PostMapping("/student/createuser")
    public ResponseEntity<?> createSuperUser(@RequestBody superuser superuser){
        superuserRepository.save(superuser);
        return ResponseEntity.ok(superuser);
    }

    @PostMapping("/student/deleteuser")
    public ResponseEntity<?> deleteSuperUser(@RequestBody superuser superuser){
        superuserRepository.delete(superuser);
        return ResponseEntity.ok(superuser);
    }
}
