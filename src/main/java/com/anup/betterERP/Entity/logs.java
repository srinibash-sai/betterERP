package com.anup.betterERP.Entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "Logs")
public class logs {
    private String ipAddress;
    private String username;
    private String timestamp;
    private String apiCalled;
    private String parameter;
}
