package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    /**
     * Finds and returns all the restaurants in the datasource.
     *
     * @return a list of restaurants.
     */
    List<Restaurant> findAllRestaurants();

    /**
     * Finds and returns a restaurant matching a given id.
     *
     * @param id a restaurant id.
     * @return an Optional containing either the restaurant or empty.
     */
    Optional<Restaurant> findRestaurantById(final Long id);

    /**
     * Saves a restaurant to the datasource.
     *
     * @param restaurant a restaurant.
     * @return the saved restaurant.
     */
    Restaurant saveRestaurant(final Restaurant restaurant);

    /**
     * Deletes a restaurant from the datasource given a restaurant id.
     *
     * @param id the id of the restaurant.
     */
    void deleteRestaurant(final Long id);

}