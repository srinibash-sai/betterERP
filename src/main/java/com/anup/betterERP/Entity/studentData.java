package com.anup.betterERP.Entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "studentData")
public class studentData {
    private int intStudentID;
    private String vchRollNo;
    private String vchName;
    private String vchGender;
    private String vchProgramName;
    private String vchAcademic;
    private String vchContactNo;
    private String vchFathersMobileNo;
    private String vchProgramShortName;
    private String vchBranchShortName;
    private String vchSection;
    private String vchRegistrationNo;
    private String proctorStatus;
    private int intSemester;
    private int intRoomNo;
    private String intAcademicSessionID;
    private String Batch;
    private String mail;
    private String imageUrl;
}
