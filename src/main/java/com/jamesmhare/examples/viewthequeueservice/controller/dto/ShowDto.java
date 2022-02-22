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
public class ShowDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long showId;

    @ApiModelProperty(required = true, value = "Name of the show.")
    @NotEmpty
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(required = true, value = "Description of the show.")
    @NotEmpty
    @JsonProperty("description")
    private String description;

    @ApiModelProperty(required = true, value = "The operating status of the show.")
    @JsonProperty("operatingStatus")
    private OperatingStatus operatingStatus;

    @ApiModelProperty(required = true, value = "The opening time of the show.")
    @JsonProperty("openingTime")
    private Date openingTime;

    @ApiModelProperty(required = true, value = "The closing time of the show.")
    @JsonProperty("closingTime")
    private Date closingTime;

    @ApiModelProperty(required = true, value = "Area of the show.")
    @NotEmpty
    @JsonProperty("area")
    private Area area;

    @ApiModelProperty(required = true, value = "The Theme Park in which the show is located.")
    @NotEmpty
    @JsonProperty("themePark")
    private ThemePark themePark;

}
