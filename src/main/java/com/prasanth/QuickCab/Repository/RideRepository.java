package com.prasanth.QuickCab.Repository;

import com.prasanth.QuickCab.Entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<RideEntity,Long> {

    List<RideEntity> findByRiderId(Long riderId);
}
