package com.User.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String id;
    private String name;
    private String email;
    private String memberShipType;
    private LocalDate registrationDate;
    private Boolean active;
    private List<BookResponseDto> bookList;
}
