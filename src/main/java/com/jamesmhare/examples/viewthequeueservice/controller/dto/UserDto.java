package com.jamesmhare.examples.viewthequeueservice.controller.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String emailAddress;
    @ToString.Exclude
    private String password;
    @ToString.Exclude
    private String repeatedPassword;

}
