package com.jamesmhare.examples.viewthequeueservice.controller.mapper;

import com.jamesmhare.examples.viewthequeueservice.model.Attraction;
import com.jamesmhare.examples.viewthequeueservice.controller.dto.AttractionDto;
import org.mapstruct.Mapper;

/**
 * Serves as a Mapper to convert a {@link Attraction} object to a {@link AttractionDto} object.
 *
 * @author James Hare
 */
@Mapper(componentModel = "spring")
public interface AttractionMapper {

    AttractionDto attractionToAttractionDto(final Attraction attraction);

    Attraction attractionDtoToAttraction(final AttractionDto attractionDto);

}
