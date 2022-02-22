package com.jamesmhare.examples.viewthequeueservice.controller;

import com.jamesmhare.examples.viewthequeueservice.controller.dto.ThemeParkDto;
import com.jamesmhare.examples.viewthequeueservice.controller.mapper.ThemeParkMapper;
import com.jamesmhare.examples.viewthequeueservice.model.ThemePark;
import com.jamesmhare.examples.viewthequeueservice.service.ThemeParkService;
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

@Api(tags = "Theme Park Management")
@RequestMapping("/v1/theme-parks")
@RestController
@Slf4j
public class ThemeParkController {

    final private ThemeParkService themeParkService;
    final private ThemeParkMapper themeParkMapper;

    public ThemeParkController(final ThemeParkService themeParkService, final ThemeParkMapper themeParkMapper) {
        this.themeParkService = themeParkService;
        this.themeParkMapper = themeParkMapper;
    }

    @ApiOperation(
            value = "Get all Theme Parks",
            nickname = "getThemeParks",
            notes = "This API fetches all existing Theme Parks in the data source.",
            response = ThemeParkDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Theme Parks retrieved successfully", response = ThemeParkDto.class, responseContainer = "List")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ThemeParkDto>> getThemeParks() {
        final List<ThemeParkDto> themeParks =
                this.themeParkService.findAllThemeParks().stream()
                        .map(this.themeParkMapper::themeParkToThemeParkDto)
                        .collect(Collectors.toList());
        return ResponseEntity.ok(themeParks);
    }

    @ApiOperation(
            value = "Get a single Theme Park given an themePark ID",
            nickname = "getThemePark",
            notes = "This API fetches a single Theme Park given an themePark ID.",
            response = ThemeParkDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Theme Park retrieved successfully", response = ThemeParkDto.class),
            @ApiResponse(code = 404, message = "No Theme Parks match the id given.")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ThemeParkDto> getThemePark(
            @ApiParam(value = "id of a Theme Park.", required = true)
            @PathVariable final Long id) {
        final Optional<ThemePark> themePark = this.themeParkService.findThemeParkById(id);
        return themePark.map(
                value -> ResponseEntity
                        .ok(this.themeParkMapper.themeParkToThemeParkDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(
            value = "Add a Theme Park",
            nickname = "addThemePark",
            notes = "This API adds a new Theme Park.",
            response = ThemeParkDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Theme Park added successfully", response = ThemeParkDto.class)})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ThemeParkDto> addThemePark(
            @ApiParam(value = "New Theme Park.", required = true)
            @Valid
            @RequestBody final ThemeParkDto themePark) {
        final ThemePark savedThemePark = this.themeParkService
                .saveThemePark(this.themeParkMapper.themeParkDtoToThemePark(themePark));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.themeParkMapper.themeParkToThemeParkDto(savedThemePark));
    }

    @ApiOperation(
            value = "Update a single Theme Park given a Theme Park and a Theme Park ID",
            nickname = "updateThemePark",
            notes = "This API updates a single Theme Park that matches a given Theme Park ID.",
            response = ThemeParkDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Theme Park updated successfully", response = ThemeParkDto.class),
            @ApiResponse(code = 404, message = "No Theme Parks match the id given.")})
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ThemeParkDto> updateThemePark(
            @ApiParam(value = "id of an existing Theme Park.", required = true)
            @PathVariable final Long id,
            @ApiParam(value = "Updated Theme Park.", required = true)
            @Valid
            @RequestBody final ThemeParkDto themePark) {
        final Optional<ThemePark> existingThemePark = this.themeParkService
                .findThemeParkById(id);
        if (existingThemePark.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        themePark.setThemeParkId(id);
        final ThemePark savedThemePark = this.themeParkService
                .saveThemePark(this.themeParkMapper.themeParkDtoToThemePark(themePark));
        return ResponseEntity
                .ok(this.themeParkMapper.themeParkToThemeParkDto(savedThemePark));
    }

    @ApiOperation(
            value = "Delete a single Theme Park given a Theme Park ID",
            nickname = "deleteThemePark",
            notes = "This API deletes a single Theme Park given a Theme Park ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Theme Park deleted successfully"),
            @ApiResponse(code = 404, message = "No Theme Parks match the id given.")})
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteThemePark(
            @ApiParam(value = "id of an themePark.", required = true)
            @PathVariable final Long id) {
        if (this.themeParkService.findThemeParkById(id).isPresent()) {
            this.themeParkService.deleteThemePark(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
