package com.User.Service.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "Users")
public class Users {

    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String memberShipType;
    private LocalDate registrationDate;
    private Boolean active;

}
