package com.example.finalproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String accountName;
    private String passwordId;
    private String email;
    private String state;
    private String city;
    private String street;
    private String houseNumber;
    private String zipCode;



}
