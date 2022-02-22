package com.jamesmhare.examples.viewthequeueservice.repo;

import com.jamesmhare.examples.viewthequeueservice.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}
