package com.jamesmhare.examples.viewthequeueservice.repo;

import com.jamesmhare.examples.viewthequeueservice.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, UUID> {
}
