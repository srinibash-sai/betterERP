package com.anup.betterERP.Entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "badLoginLog")
public class badLoginLog {
    private String ipAddress;
    private String username;
    private String password;
    private String timestamp;
    private String apiCalled;
    private String parameter;
}
