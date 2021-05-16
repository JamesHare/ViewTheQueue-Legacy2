package com.jamesmhare.examples.viewthequeueservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamesmhare.examples.viewthequeueservice.model.ThemePark;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@Builder
@Validated
public class RestaurantDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private UUID id;
    @ApiModelProperty(required = true, value = "Area of the attraction.")
    @NotEmpty
    @JsonProperty("area")
    private String area;
    @ApiModelProperty(required = true, value = "Description of the restaurant.")
    @NotEmpty
    @JsonProperty("description")
    private String description;
    @ApiModelProperty(required = true, value = "Area of the attraction.")
    @NotEmpty
    @JsonProperty("servesVegetarian")
    private boolean servesVegetarian;
    @ApiModelProperty(required = true, value = "Area of the attraction.")
    @NotEmpty
    @JsonProperty("servesVegan")
    private boolean servesVegan;
    @ApiModelProperty(required = true, value = "The Theme Park in which the attraction is located.")
    @NotEmpty
    @JsonProperty("themePark")
    private ThemePark themePark;

}
