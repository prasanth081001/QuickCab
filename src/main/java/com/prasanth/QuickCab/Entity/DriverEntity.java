package com.prasanth.QuickCab.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String vehicleNumber;

    private Boolean available;

    private String vehicleType;

    private Double rating;

    private Integer totalTrips;

    private LocalDateTime registeredAt;

}
