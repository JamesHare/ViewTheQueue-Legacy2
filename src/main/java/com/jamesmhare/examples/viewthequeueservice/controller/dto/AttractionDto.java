package com.jamesmhare.examples.viewthequeueservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamesmhare.examples.viewthequeueservice.model.ThemePark;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
@Validated
public class AttractionDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private UUID id;
    @ApiModelProperty(required = true, value = "Area of the attraction.")
    @NotEmpty
    @JsonProperty("area")
    private String area;
    @ApiModelProperty(required = true, value = "Description of the attraction.")
    @NotEmpty
    @JsonProperty("description")
    private String description;
    @ApiModelProperty(required = true, value = "The current wait time of the attraction.")
    @JsonProperty("waitTime")
    private Integer waitTime;
    @ApiModelProperty(required = true, value = "Max Height restriction of the attraction in inches.")
    @NotEmpty
    @JsonProperty("maxHeightRestrictionInches")
    private Integer maxHeightRestrictionInches;
    @ApiModelProperty(required = true, value = "Min Height restriction of the attraction in inches.")
    @NotEmpty
    @JsonProperty("minHeightRestrictionInches")
    private Integer minHeightRestrictionInches;
    @ApiModelProperty(required = true, value = "If the attraction has an express line.")
    @NotEmpty
    @JsonProperty("hasExpressLine")
    private boolean hasExpressLine;
    @ApiModelProperty(required = true, value = "If the attraction has a single rider line.")
    @NotEmpty
    @JsonProperty("hasSingleRider")
    private boolean hasSingleRider;
    @ApiModelProperty(required = true, value = "The Theme Park in which the attraction is located.")
    @NotEmpty
    @JsonProperty("themePark")
    private ThemePark themePark;

}
