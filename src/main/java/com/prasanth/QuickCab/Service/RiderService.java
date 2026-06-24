package com.prasanth.QuickCab.Service;

import com.prasanth.QuickCab.DTO.RiderRequestDTTO;
import com.prasanth.QuickCab.Entity.RiderEntity;
import com.prasanth.QuickCab.Exception.ResourceNotFoundException;
import com.prasanth.QuickCab.Repository.RiderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RiderService {
    private final RiderRepository riderRepository;

    public RiderEntity registerRider(RiderRequestDTTO dto) {

        RiderEntity rider = new RiderEntity();

        rider.setName(dto.getName());
        rider.setPhone(dto.getPhone());
        rider.setEmail(dto.getEmail());
        rider.setAddress(dto.getAddress());
        rider.setGender(dto.getGender());
        rider.setRegisteredAt(LocalDateTime.now());

        return riderRepository.save(rider);
    }

    public RiderEntity getRiderById(Long id) {

        return riderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Rider not found with ID : " + id));
    }

    public List<RiderEntity> getAllRiders() {
        return riderRepository.findAll();
    }

}
