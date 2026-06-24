package com.prasanth.QuickCab.Controller;

import com.prasanth.QuickCab.DTO.DriverRequestDTO;
import com.prasanth.QuickCab.Entity.DriverEntity;
import com.prasanth.QuickCab.Service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @PostMapping
    public DriverEntity registerDriver(
            @RequestBody DriverRequestDTO dto) {

        return driverService.registerDriver(dto);
    }

    @GetMapping("/{id}")
    public DriverEntity getDriver(
            @PathVariable Long id) {

        return driverService.getDriverById(id);
    }

    @GetMapping
    public List<DriverEntity> getAllDrivers() {

        return driverService.getAllDrivers();
    }
}
