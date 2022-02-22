package com.jamesmhare.examples.viewthequeueservice.service;

import com.jamesmhare.examples.viewthequeueservice.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {

    /**
     * Finds and returns all the areas in the datasource.
     *
     * @return a list of areas.
     */
    List<Area> findAllAreas();

    /**
     * Finds and returns an area matching a given id.
     *
     * @param id an area id.
     * @return an Optional containing either the area or empty.
     */
    Optional<Area> findAreaById(final Long id);

    /**
     * Saves an area to the datasource.
     *
     * @param area an area.
     * @return the saved area.
     */
    Area saveArea(final Area area);

    /**
     * Deletes an area from the datasource given an area id.
     *
     * @param id the id of the area.
     */
    void deleteArea(final Long id);

}
