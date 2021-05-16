package com.jamesmhare.examples.viewthequeueservice.controller.mapper;

import com.jamesmhare.examples.viewthequeueservice.model.ThemePark;
import com.jamesmhare.examples.viewthequeueservice.controller.dto.ThemeParkDto;
import org.mapstruct.Mapper;

/**
 * Serves as a Mapper to convert a {@link ThemePark} object to a {@link ThemeParkDto} object.
 *
 * @author James Hare
 */
@Mapper(componentModel = "spring")
public interface ThemeParkMapper {

    ThemeParkDto themeParkToThemeParkDto(final ThemePark themePark);

    ThemePark themeParkDtoToThemePark(final ThemeParkDto themeParkDto);

}
