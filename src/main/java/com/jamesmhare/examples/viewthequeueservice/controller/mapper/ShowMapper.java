package com.jamesmhare.examples.viewthequeueservice.controller.mapper;

import com.jamesmhare.examples.viewthequeueservice.model.Show;
import com.jamesmhare.examples.viewthequeueservice.controller.dto.ShowDto;
import org.mapstruct.Mapper;

/**
 * Serves as a Mapper to convert a {@link Show} object to a {@link ShowDto} object.
 *
 * @author James Hare
 */
@Mapper(componentModel = "spring")
public interface ShowMapper {

    ShowDto showToShowDto(final Show show);

    Show showDtoToShow(final ShowDto showDto);

}
