package com.prasanth.QuickCab.Controller;

import com.prasanth.QuickCab.DTO.RiderRequestDTTO;
import com.prasanth.QuickCab.Entity.RiderEntity;
import com.prasanth.QuickCab.Service.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/riders")
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;

    @PostMapping
    public RiderEntity registerRider(
            @RequestBody RiderRequestDTTO dto) {

        return riderService.registerRider(dto);
    }

    @GetMapping("/{id}")
    public RiderEntity getRider(
            @PathVariable Long id) {

        return riderService.getRiderById(id);
    }

    @GetMapping
    public List<RiderEntity> getAllRiders() {

        return riderService.getAllRiders();
    }
}
