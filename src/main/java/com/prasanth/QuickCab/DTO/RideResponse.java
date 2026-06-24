package com.prasanth.QuickCab.DTO;

import com.prasanth.QuickCab.Entity.RideStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideResponse {
    private Long rideId;

    private String riderName;

    private String driverName;

    private String pickupLocation;

    private String dropLocation;

    private Double fare;

    private RideStatus status;
}
