package com.prasanth.QuickCab.Service;

import com.prasanth.QuickCab.DTO.DriverRequestDTO;
import com.prasanth.QuickCab.Entity.DriverEntity;
import com.prasanth.QuickCab.Exception.ResourceNotFoundException;
import com.prasanth.QuickCab.Repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverEntity registerDriver(DriverRequestDTO dto) {

        DriverEntity driver = new DriverEntity();

        driver.setName(dto.getName());
        driver.setPhone(dto.getPhone());
        driver.setVehicleNumber(dto.getVehicleNumber());
        driver.setAvailable(dto.getAvailable());
        driver.setRating(0.0);
        driver.setTotalTrips(0);
        driver.setVehicleType(dto.getVehicleType());
        driver.setRegisteredAt(LocalDateTime.now());

        return driverRepository.save(driver);
    }

    public DriverEntity getDriverById(Long id) {

        return driverRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Driver not found with ID : " + id));
    }

    public List<DriverEntity> getAllDrivers() {
        return driverRepository.findAll();
    }

    public DriverEntity getAvailableDriver() {

        return driverRepository
                .findFirstByAvailableTrue()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No Driver Available"));
    }
}
