package com.User.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class UsersRequestDto {

    private String name;
    private String email;
    private String memberShipType;

}
