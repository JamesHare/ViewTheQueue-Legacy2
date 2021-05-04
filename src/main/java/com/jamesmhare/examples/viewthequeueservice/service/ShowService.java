package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.Show;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShowService {

    /**
     * Finds and returns all the shows in the datasource.
     *
     * @return a list of shows.
     */
    List<Show> findAllShows();

    /**
     * Finds and returns a show matching a given id.
     *
     * @param id a show id.
     * @return an Optional containing either the show or empty.
     */
    Optional<Show> findShowById(final UUID id);

    /**
     * Saves a show to the datasource.
     *
     * @param show a show.
     * @return the saved show.
     */
    Show saveShow(final Show show);

    /**
     * Deletes a show from the datasource given a show id.
     *
     * @param id the id of the show.
     */
    void deleteShow(final UUID id);

}