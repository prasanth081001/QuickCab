package com.prasanth.QuickCab.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideRequestDTO {
    private Long riderId;
    private String pickupLocation;

    private String dropLocation;
    private String paymentMode;

}
