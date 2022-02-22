package com.jamesmhare.examples.viewthequeueservice.repo;

import com.jamesmhare.examples.viewthequeueservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
