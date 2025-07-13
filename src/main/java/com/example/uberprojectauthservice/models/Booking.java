package com.example.uberprojectauthservice.models;
import com.example.uberprojectauthservice.models.BaseModel;
import com.example.uberprojectauthservice.models.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking extends BaseModel {

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

}
