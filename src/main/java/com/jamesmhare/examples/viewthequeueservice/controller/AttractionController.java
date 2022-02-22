package com.jamesmhare.examples.viewthequeueservice.controller;

import com.jamesmhare.examples.viewthequeueservice.controller.dto.AttractionDto;
import com.jamesmhare.examples.viewthequeueservice.controller.mapper.AttractionMapper;
import com.jamesmhare.examples.viewthequeueservice.model.Attraction;
import com.jamesmhare.examples.viewthequeueservice.service.AttractionService;
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

@Api(tags = "Attractions Management")
@RequestMapping("/v1/attractions")
@RestController
@Slf4j
public class AttractionController {

    final private AttractionService attractionService;
    final private AttractionMapper attractionMapper;

    public AttractionController(final AttractionService attractionService, final AttractionMapper attractionMapper) {
        this.attractionService = attractionService;
        this.attractionMapper = attractionMapper;
    }

    @ApiOperation(
            value = "Get all Attractions",
            nickname = "getAttractions",
            notes = "This API fetches all existing attractions in the data source.",
            response = AttractionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Attractions retrieved successfully", response = AttractionDto.class, responseContainer = "List")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AttractionDto>> getAttractions() {
        final List<AttractionDto> attractions =
                this.attractionService.findAllAttractions().stream()
                        .map(this.attractionMapper::attractionToAttractionDto)
                        .collect(Collectors.toList());
        return ResponseEntity.ok(attractions);
    }

    @ApiOperation(
            value = "Get a single attraction given an attraction ID",
            nickname = "getAttraction",
            notes = "This API fetches a single attraction given an attraction ID.",
            response = AttractionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Attraction retrieved successfully", response = AttractionDto.class),
            @ApiResponse(code = 404, message = "No attractions match the id given.")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttractionDto> getAttraction(
            @ApiParam(value = "id of an attraction.", required = true)
            @PathVariable final Long id) {
        final Optional<Attraction> attraction = this.attractionService.findAttractionById(id);
        return attraction.map(
                value -> ResponseEntity
                        .ok(this.attractionMapper.attractionToAttractionDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(
            value = "Add an attraction",
            nickname = "addAttraction",
            notes = "This API adds a new attraction.",
            response = AttractionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Attraction added successfully", response = AttractionDto.class)})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttractionDto> addAttraction(
            @ApiParam(value = "New attraction.", required = true)
            @Valid
            @RequestBody final AttractionDto attraction) {
        final Attraction savedAttraction = this.attractionService
                .saveAttraction(this.attractionMapper.attractionDtoToAttraction(attraction));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.attractionMapper.attractionToAttractionDto(savedAttraction));
    }

    @ApiOperation(
            value = "Update a single attraction given an attraction and an attraction ID",
            nickname = "updateAttraction",
            notes = "This API updates a single attraction that matches a given attraction ID.",
            response = AttractionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Attraction updated successfully", response = AttractionDto.class),
            @ApiResponse(code = 404, message = "No attractions match the id given.")})
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttractionDto> updateAttraction(
            @ApiParam(value = "id of an existing attraction.", required = true)
            @PathVariable final Long id,
            @ApiParam(value = "Updated attraction.", required = true)
            @Valid
            @RequestBody final AttractionDto attraction) {
        final Optional<Attraction> existingAttraction = this.attractionService
                .findAttractionById(id);
        if (existingAttraction.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        attraction.setAttractionId(id);
        final Attraction savedAttraction = this.attractionService
                .saveAttraction(this.attractionMapper.attractionDtoToAttraction(attraction));
        return ResponseEntity
                .ok(this.attractionMapper.attractionToAttractionDto(savedAttraction));
    }

    @ApiOperation(
            value = "Delete a single attraction given an attraction ID",
            nickname = "deleteAttraction",
            notes = "This API deletes a single attraction given an attraction ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Attraction deleted successfully"),
            @ApiResponse(code = 404, message = "No attractions match the id given.")})
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAttraction(
            @ApiParam(value = "id of an attraction.", required = true)
            @PathVariable final Long id) {
        if (this.attractionService.findAttractionById(id).isPresent()) {
            this.attractionService.deleteAttraction(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
