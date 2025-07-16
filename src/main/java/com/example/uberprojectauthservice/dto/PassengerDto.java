package com.example.uberprojectauthservice.dto;

import com.example.uberprojectentityservice.models.Passenger;
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

    public static PassengerDto from(Passenger p) {

        return PassengerDto.builder()
                .id(p.getId())
                .name(p.getName())
                .password(p.getPassword())
                .email(p.getEmail())
                .phoneNumber(p.getPhoneNumber())
                .createdAt(p.getCreatedAt())
                .build();
    }
}
