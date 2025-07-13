package com.example.uberprojectauthservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface JwtService extends CommandLineRunner {

    /**
     * This method creates a brand-new JWT Token based on payload.
     * @return String
     */
    public String createToken(Map<String,Object> payload,String username);

}
