package com.jamesmhare.examples.viewthequeueservice.repo;

import com.jamesmhare.examples.viewthequeueservice.model.Show;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface ShowRepository extends JpaRepository<Show, UUID> {
}
