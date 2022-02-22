package com.jamesmhare.examples.viewthequeueservice.controller;

import com.jamesmhare.examples.viewthequeueservice.controller.dto.RestaurantDto;
import com.jamesmhare.examples.viewthequeueservice.controller.mapper.RestaurantMapper;
import com.jamesmhare.examples.viewthequeueservice.model.Restaurant;
import com.jamesmhare.examples.viewthequeueservice.service.RestaurantService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(tags = "Restaurant Management")
@RequestMapping("/v1/restaurants")
@RestController
@Slf4j
public class RestaurantController {

    final private RestaurantService restaurantService;
    final private RestaurantMapper restaurantMapper;

    public RestaurantController(final RestaurantService restaurantService, final RestaurantMapper restaurantMapper) {
        this.restaurantService = restaurantService;
        this.restaurantMapper = restaurantMapper;
    }

    @ApiOperation(
            value = "Get all Restaurants",
            nickname = "getRestaurants",
            notes = "This API fetches all existing restaurants in the data source.",
            response = RestaurantDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Restaurants retrieved successfully", response = RestaurantDto.class, responseContainer = "List")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RestaurantDto>> getRestaurants() {
        final List<RestaurantDto> restaurants =
                this.restaurantService.findAllRestaurants().stream()
                        .map(this.restaurantMapper::restaurantToRestaurantDto)
                        .collect(Collectors.toList());
        return ResponseEntity.ok(restaurants);
    }

    @ApiOperation(
            value = "Get a single restaurant given a restaurant ID",
            nickname = "getRestaurant",
            notes = "This API fetches a single restaurant given a restaurant ID.",
            response = RestaurantDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Restaurant retrieved successfully", response = RestaurantDto.class),
            @ApiResponse(code = 404, message = "No restaurants match the id given.")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantDto> getRestaurant(
            @ApiParam(value = "id of a restaurant.", required = true)
            @PathVariable final Long id) {
        final Optional<Restaurant> restaurant = this.restaurantService.findRestaurantById(id);
        return restaurant.map(
                value -> ResponseEntity
                        .ok(this.restaurantMapper.restaurantToRestaurantDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(
            value = "Add a restaurant",
            nickname = "addRestaurant",
            notes = "This API adds a new restaurant.",
            response = RestaurantDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Restaurant added successfully", response = RestaurantDto.class)})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantDto> addRestaurant(
            @ApiParam(value = "New restaurant.", required = true)
            @Valid
            @RequestBody final RestaurantDto restaurant) {
        final Restaurant savedRestaurant = this.restaurantService
                .saveRestaurant(this.restaurantMapper.restaurantDtoToRestaurant(restaurant));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.restaurantMapper.restaurantToRestaurantDto(savedRestaurant));
    }

    @ApiOperation(
            value = "Update a single restaurant given a restaurant and a restaurant ID",
            nickname = "updateRestaurant",
            notes = "This API updates a single restaurant that matches a given restaurant ID.",
            response = RestaurantDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Restaurant updated successfully", response = RestaurantDto.class),
            @ApiResponse(code = 404, message = "No restaurants match the id given.")})
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantDto> updateRestaurant(
            @ApiParam(value = "id of an existing restaurant.", required = true)
            @PathVariable final Long id,
            @ApiParam(value = "Updated restaurant.", required = true)
            @Valid
            @RequestBody final RestaurantDto restaurant) {
        final Optional<Restaurant> existingRestaurant = this.restaurantService
                .findRestaurantById(id);
        if (existingRestaurant.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        restaurant.setRestaurantId(id);
        final Restaurant savedRestaurant = this.restaurantService
                .saveRestaurant(this.restaurantMapper.restaurantDtoToRestaurant(restaurant));
        return ResponseEntity
                .ok(this.restaurantMapper.restaurantToRestaurantDto(savedRestaurant));
    }

    @ApiOperation(
            value = "Delete a single restaurant given an restaurant ID",
            nickname = "deleteRestaurant",
            notes = "This API deletes a single restaurant given an restaurant ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Restaurant deleted successfully"),
            @ApiResponse(code = 404, message = "No restaurants match the id given.")})
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteRestaurant(
            @ApiParam(value = "id of an restaurant.", required = true)
            @PathVariable final Long id) {
        if (this.restaurantService.findRestaurantById(id).isPresent()) {
            this.restaurantService.deleteRestaurant(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
