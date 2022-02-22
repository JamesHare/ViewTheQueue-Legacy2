package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.Attraction;

import java.util.List;
import java.util.Optional;

public interface AttractionService {

    /**
     * Finds and returns all the attractions in the datasource.
     *
     * @return a list of attractions.
     */
    List<Attraction> findAllAttractions();

    /**
     * Finds and returns a attraction matching a given id.
     *
     * @param id a attraction id.
     * @return an Optional containing either the attraction or empty.
     */
    Optional<Attraction> findAttractionById(final Long id);

    /**
     * Saves a attraction to the datasource.
     *
     * @param attraction a attraction.
     * @return the saved attraction.
     */
    Attraction saveAttraction(final Attraction attraction);

    /**
     * Deletes a attraction from the datasource given a attraction id.
     *
     * @param id the id of the attraction.
     */
    void deleteAttraction(final Long id);

}