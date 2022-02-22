package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.Restaurant;
import com.jamesmhare.examples.viewthequeueservice.repo.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A service class for communicating with the {@link RestaurantRepository}.
 *
 * @author James Hare
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantServiceImpl(final RestaurantRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    public List<Restaurant> findAllRestaurants() {
        return this.repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    public Optional<Restaurant> findRestaurantById(final Long id) {
        return this.repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    public Restaurant saveRestaurant(final Restaurant restaurant) {
        return this.repository.save(restaurant);
    }

    /**
     * {@inheritDoc}
     */
    public void deleteRestaurant(final Long id) {
        this.repository.deleteById(id);
    }
}