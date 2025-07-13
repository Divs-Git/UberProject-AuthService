package com.example.uberprojectauthservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerDto {
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phoneNumber;

    private Date createdAt;
}
