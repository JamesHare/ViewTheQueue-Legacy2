package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.ThemePark;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ThemeParkService {

    /**
     * Finds and returns all the theme parks in the datasource.
     *
     * @return a list of theme parks.
     */
    List<ThemePark> findAllThemeParks();

    /**
     * Finds and returns a theme park matching a given id.
     *
     * @param id a theme park id.
     * @return an Optional containing either the theme park or empty.
     */
    Optional<ThemePark> findThemeParkById(final UUID id);

    /**
     * Saves a theme park to the datasource.
     *
     * @param themePark park a theme park.
     * @return the saved theme park.
     */
    ThemePark saveThemePark(final ThemePark themePark);

    /**
     * Deletes a theme park from the datasource given a theme park id.
     *
     * @param id the id of the theme park.
     */
    void deleteThemePark(final UUID id);

}