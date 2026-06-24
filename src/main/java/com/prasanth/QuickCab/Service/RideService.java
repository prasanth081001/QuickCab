package com.prasanth.QuickCab.Service;

import com.prasanth.QuickCab.DTO.RideRequestDTO;
import com.prasanth.QuickCab.DTO.RideResponse;
import com.prasanth.QuickCab.Entity.DriverEntity;
import com.prasanth.QuickCab.Entity.RideEntity;
import com.prasanth.QuickCab.Entity.RideStatus;
import com.prasanth.QuickCab.Entity.RiderEntity;
import com.prasanth.QuickCab.Exception.ResourceNotFoundException;
import com.prasanth.QuickCab.Repository.DriverRepository;
import com.prasanth.QuickCab.Repository.RideRepository;
import com.prasanth.QuickCab.Repository.RiderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository rideRepository;
    private final RiderRepository riderRepository;
    private final DriverRepository driverRepository;

    public RideResponse requestRide(
            RideRequestDTO dto) {

        RiderEntity rider = riderRepository.findById(
                        dto.getRiderId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Rider Not Found"));

        DriverEntity driver = driverRepository
                .findFirstByAvailableTrue()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No Driver Available"));

        driver.setAvailable(false);

        driverRepository.save(driver);

        RideEntity ride = new RideEntity();

        ride.setPickupLocation(
                dto.getPickupLocation());

        ride.setDropLocation(
                dto.getDropLocation());

        ride.setRider(rider);

        ride.setDriver(driver);

        ride.setStatus(
                RideStatus.REQUESTED);

        ride.setFare(150.0);
        ride.setPaymentMode(dto.getPaymentMode());
        ride.setRideDate(LocalDateTime.now());
        ride.setDistanceKm(10.0);

        RideEntity savedRide =
                rideRepository.save(ride);

        RideResponse response = new RideResponse();

        response.setRideId(savedRide.getId());

        response.setRiderName(
                rider.getName());

        response.setDriverName(
                driver.getName());

        response.setPickupLocation(
                savedRide.getPickupLocation());

        response.setDropLocation(
                savedRide.getDropLocation());

        response.setFare(
                savedRide.getFare());

        response.setStatus(
                savedRide.getStatus());

        return response;
    }

    public RideEntity updateRideStatus(
            Long rideId,
            RideStatus status) {

        RideEntity ride = rideRepository
                .findById(rideId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ride Not Found"));

        ride.setStatus(status);

        if (status == RideStatus.COMPLETED) {

            DriverEntity driver = ride.getDriver();

            driver.setAvailable(true);
            driver.setTotalTrips(driver.getTotalTrips()+1);

            driverRepository.save(driver);
        }

        return rideRepository.save(ride);
    }

    public List<RideEntity> getRideHistory(
            Long riderId) {

        return rideRepository
                .findByRiderId(riderId);
    }
}
