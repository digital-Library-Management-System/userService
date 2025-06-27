package com.User.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponseDto {

    private String id;
    private String name;
    private String email;
    private String memberShipType;
    private LocalDate registrationDate;
    private Boolean active;
}
