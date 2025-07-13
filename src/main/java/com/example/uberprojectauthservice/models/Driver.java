package com.example.uberprojectauthservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Setter
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    // 1 : n -> Driver: bookings
    @OneToMany(mappedBy = "driver")
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings;
}
