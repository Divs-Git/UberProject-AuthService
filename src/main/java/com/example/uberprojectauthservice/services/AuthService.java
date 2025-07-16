package com.example.uberprojectauthservice.services;

import com.example.uberprojectauthservice.dto.PassengerDto;
import com.example.uberprojectauthservice.dto.PassengerSignupRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public PassengerDto signupPassenger(PassengerSignupRequestDto passengerSignupRequestDto);
}
