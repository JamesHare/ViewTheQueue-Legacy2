package com.jamesmhare.examples.viewthequeueservice.controller.mapper;

import com.jamesmhare.examples.viewthequeueservice.controller.dto.AreaDto;
import com.jamesmhare.examples.viewthequeueservice.model.Area;
import org.mapstruct.Mapper;

/**
 * Serves as a Mapper to convert an {@link Area} object to a {@link AreaDto} object.
 *
 * @author James Hare
 */
@Mapper(componentModel = "spring")
public interface AreaMapper {

    AreaDto areaToAreaDto(final Area area);

    Area areaDtoToArea(final AreaDto areaDto);
    
}
