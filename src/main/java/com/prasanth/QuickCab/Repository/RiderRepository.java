package com.prasanth.QuickCab.Repository;

import com.prasanth.QuickCab.Entity.RiderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RiderRepository extends JpaRepository<RiderEntity,Long> {
}
