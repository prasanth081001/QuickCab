package com.prasanth.QuickCab.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverRequestDTO {
    private String name;

    private String phone;

    private String vehicleNumber;

    private Boolean available;
    private String vehicleType;
}
