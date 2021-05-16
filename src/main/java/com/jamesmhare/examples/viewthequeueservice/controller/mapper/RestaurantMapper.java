package com.jamesmhare.examples.viewthequeueservice.controller.mapper;

import com.jamesmhare.examples.viewthequeueservice.model.Restaurant;
import com.jamesmhare.examples.viewthequeueservice.controller.dto.RestaurantDto;
import org.mapstruct.Mapper;

/**
 * Serves as a Mapper to convert a {@link Restaurant} object to a {@link RestaurantDto} object.
 *
 * @author James Hare
 */
@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantDto restaurantToRestaurantDto(final Restaurant restaurant);

    Restaurant restaurantDtoToRestaurant(final RestaurantDto restaurantDto);

}
