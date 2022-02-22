package com.jamesmhare.examples.viewthequeueservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamesmhare.examples.viewthequeueservice.model.Area;
import com.jamesmhare.examples.viewthequeueservice.model.OperatingStatus;
import com.jamesmhare.examples.viewthequeueservice.model.ThemePark;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@Validated
public class RestaurantDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long restaurantId;

    @ApiModelProperty(required = true, value = "Name of the restaurant.")
    @NotEmpty
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(required = true, value = "Description of the restaurant.")
    @NotEmpty
    @JsonProperty("description")
    private String description;

    @ApiModelProperty(required = true, value = "The operating status of the restaurant.")
    @JsonProperty("operatingStatus")
    private OperatingStatus operatingStatus;

    @ApiModelProperty(required = true, value = "The opening time of the restaurant.")
    @JsonProperty("openingTime")
    private Date openingTime;

    @ApiModelProperty(required = true, value = "The closing time of the restaurant.")
    @JsonProperty("closingTime")
    private Date closingTime;

    @ApiModelProperty(required = true, value = "If the restaurant serves vegetarian food.")
    @NotEmpty
    @JsonProperty("servesVegetarian")
    private boolean servesVegetarian;

    @ApiModelProperty(required = true, value = "If the restaurant serves vegan food.")
    @NotEmpty
    @JsonProperty("servesVegan")
    private boolean servesVegan;

    @ApiModelProperty(required = true, value = "Area of the restaurant.")
    @NotEmpty
    @JsonProperty("area")
    private Area area;

    @ApiModelProperty(required = true, value = "The Theme Park in which the restaurant is located.")
    @NotEmpty
    @JsonProperty("themePark")
    private ThemePark themePark;

}
