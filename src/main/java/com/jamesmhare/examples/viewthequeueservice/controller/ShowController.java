package com.jamesmhare.examples.viewthequeueservice.controller;

import com.jamesmhare.examples.viewthequeueservice.controller.dto.ShowDto;
import com.jamesmhare.examples.viewthequeueservice.controller.mapper.ShowMapper;
import com.jamesmhare.examples.viewthequeueservice.model.Show;
import com.jamesmhare.examples.viewthequeueservice.service.ShowService;
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

@Api(tags = "Show Management")
@RequestMapping("/v1/shows")
@RestController
@Slf4j
public class ShowController {

    final private ShowService showService;
    final private ShowMapper showMapper;

    public ShowController(final ShowService showService, final ShowMapper showMapper) {
        this.showService = showService;
        this.showMapper = showMapper;
    }

    @ApiOperation(
            value = "Get all Shows",
            nickname = "getShows",
            notes = "This API fetches all existing shows in the data source.",
            response = ShowDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Shows retrieved successfully", response = ShowDto.class, responseContainer = "List")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShowDto>> getShows() {
        final List<ShowDto> shows =
                this.showService.findAllShows().stream()
                        .map(this.showMapper::showToShowDto)
                        .collect(Collectors.toList());
        return ResponseEntity.ok(shows);
    }

    @ApiOperation(
            value = "Get a single show given a show ID",
            nickname = "getShow",
            notes = "This API fetches a single show given a show ID.",
            response = ShowDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Show retrieved successfully", response = ShowDto.class),
            @ApiResponse(code = 404, message = "No shows match the id given.")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowDto> getShow(
            @ApiParam(value = "id of a show.", required = true)
            @PathVariable final Long id) {
        final Optional<Show> show = this.showService.findShowById(id);
        return show.map(
                value -> ResponseEntity
                        .ok(this.showMapper.showToShowDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(
            value = "Add a show",
            nickname = "addShow",
            notes = "This API adds a new show.",
            response = ShowDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Show added successfully", response = ShowDto.class)})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowDto> addShow(
            @ApiParam(value = "New show.", required = true)
            @Valid
            @RequestBody final ShowDto show) {
        final Show savedShow = this.showService
                .saveShow(this.showMapper.showDtoToShow(show));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.showMapper.showToShowDto(savedShow));
    }

    @ApiOperation(
            value = "Update a single show given a show and a show ID",
            nickname = "updateShow",
            notes = "This API updates a single show that matches a given show ID.",
            response = ShowDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Show updated successfully", response = ShowDto.class),
            @ApiResponse(code = 404, message = "No shows match the id given.")})
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowDto> updateShow(
            @ApiParam(value = "id of an existing show.", required = true)
            @PathVariable final Long id,
            @ApiParam(value = "Updated show.", required = true)
            @Valid
            @RequestBody final ShowDto show) {
        final Optional<Show> existingShow = this.showService
                .findShowById(id);
        if (existingShow.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        show.setShowId(id);
        final Show savedShow = this.showService
                .saveShow(this.showMapper.showDtoToShow(show));
        return ResponseEntity
                .ok(this.showMapper.showToShowDto(savedShow));
    }

    @ApiOperation(
            value = "Delete a single show given a show ID",
            nickname = "deleteShow",
            notes = "This API deletes a single show given a show ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Show deleted successfully"),
            @ApiResponse(code = 404, message = "No shows match the id given.")})
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteShow(
            @ApiParam(value = "id of a show.", required = true)
            @PathVariable final Long id) {
        if (this.showService.findShowById(id).isPresent()) {
            this.showService.deleteShow(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
