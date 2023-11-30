package com.anup.betterERP.Entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "superuser")
public class superuser {
    private String name;
    private String password;
}
