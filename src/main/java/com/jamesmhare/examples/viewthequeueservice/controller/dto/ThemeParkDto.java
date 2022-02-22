package com.jamesmhare.examples.viewthequeueservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamesmhare.examples.viewthequeueservice.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@Validated
public class ThemeParkDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long themeParkId;

    @ApiModelProperty(required = true, value = "Name of the theme park.")
    @NotEmpty
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(required = true, value = "Description of the theme park.")
    @NotEmpty
    @JsonProperty("description")
    private String description;

    @ApiModelProperty(required = true, value = "The operating status of the theme park.")
    @JsonProperty("operatingStatus")
    private OperatingStatus operatingStatus;

    @ApiModelProperty(required = true, value = "The opening time of the theme park.")
    @JsonProperty("openingTime")
    private Date openingTime;

    @ApiModelProperty(required = true, value = "The closing time of the theme park.")
    @JsonProperty("closingTime")
    private Date closingTime;

    @ApiModelProperty(required = true, value = "A list of Areas in the theme park.")
    @JsonProperty("areas")
    private Set<Area> areas;

    @ApiModelProperty(required = true, value = "A list of Attractions in the theme park.")
    @JsonProperty("attractions")
    private Set<Attraction> attractions;

    @ApiModelProperty(required = true, value = "A list of Restaurants in the theme park.")
    @JsonProperty("restaurants")
    private Set<Restaurant> restaurants;

    @ApiModelProperty(required = true, value = "A list of Shows in the theme park.")
    @JsonProperty("shows")
    private Set<Show> shows;

}
