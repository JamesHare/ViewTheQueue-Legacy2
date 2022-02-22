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
public class AttractionDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long attractionId;

    @ApiModelProperty(required = true, value = "Name of the attraction.")
    @NotEmpty
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(required = true, value = "Description of the attraction.")
    @NotEmpty
    @JsonProperty("description")
    private String description;

    @ApiModelProperty(required = true, value = "The operating status of the attraction.")
    @JsonProperty("operatingStatus")
    private OperatingStatus operatingStatus;

    @ApiModelProperty(required = true, value = "The opening time of the attraction.")
    @JsonProperty("openingTime")
    private Date openingTime;

    @ApiModelProperty(required = true, value = "The closing time of the attraction.")
    @JsonProperty("closingTime")
    private Date closingTime;

    @ApiModelProperty(required = true, value = "The current wait time of the attraction.")
    @JsonProperty("waitTime")
    private Long waitTime;

    @ApiModelProperty(required = true, value = "Max Height restriction of the attraction in inches.")
    @NotEmpty
    @JsonProperty("maxHeightInches")
    private Integer maxHeightInches;

    @ApiModelProperty(required = true, value = "Min Height restriction of the attraction in inches.")
    @NotEmpty
    @JsonProperty("minHeightInches")
    private Integer minHeightInches;

    @ApiModelProperty(required = true, value = "If the attraction has an express line.")
    @NotEmpty
    @JsonProperty("hasExpressLine")
    private boolean hasExpressLine;

    @ApiModelProperty(required = true, value = "If the attraction has a single rider line.")
    @NotEmpty
    @JsonProperty("hasSingleRider")
    private boolean hasSingleRider;

    @ApiModelProperty(required = true, value = "Area of the attraction.")
    @NotEmpty
    @JsonProperty("area")
    private Area area;

    @ApiModelProperty(required = true, value = "The Theme Park in which the attraction is located.")
    @NotEmpty
    @JsonProperty("themePark")
    private ThemePark themePark;

}
