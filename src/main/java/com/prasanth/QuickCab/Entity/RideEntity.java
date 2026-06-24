package com.prasanth.QuickCab.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
    @Table(name = "rides")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class RideEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String pickupLocation;

        private String dropLocation;

        @Enumerated(EnumType.STRING)
        private RideStatus status;

        private Double fare;

        private Double distanceKm;

        private String paymentMode;

        private LocalDateTime rideDate;

        @ManyToOne
        @JoinColumn(name = "rider_id")
        private RiderEntity rider;

        @ManyToOne
        @JoinColumn(name = "driver_id")
        private DriverEntity driver;
    }
