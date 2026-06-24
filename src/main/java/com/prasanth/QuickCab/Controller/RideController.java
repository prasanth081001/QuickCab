package com.prasanth.QuickCab.Controller;

import com.prasanth.QuickCab.DTO.RideRequestDTO;
import com.prasanth.QuickCab.DTO.RideResponse;
import com.prasanth.QuickCab.Entity.RideEntity;
import com.prasanth.QuickCab.Entity.RideStatus;
import com.prasanth.QuickCab.Service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
public class RideController {
    private final RideService rideService;

    @PostMapping("/request")
    public RideResponse requestRide(
            @RequestBody RideRequestDTO dto) {

        return rideService.requestRide(dto);
    }

    @PutMapping("/{rideId}/status")
    public RideEntity updateRideStatus(
            @PathVariable Long rideId,
            @RequestParam RideStatus status) {

        return rideService.updateRideStatus(
                rideId,
                status);
    }

    @GetMapping("/history/{riderId}")
    public List<RideEntity> getRideHistory(
            @PathVariable Long riderId) {

        return rideService.getRideHistory(riderId);
    }
}
