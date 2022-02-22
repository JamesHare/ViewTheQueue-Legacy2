package com.jamesmhare.examples.viewthequeueservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamesmhare.examples.viewthequeueservice.model.ThemePark;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Validated
public class AreaDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long areaId;

    @ApiModelProperty(required = true, value = "Name of the area.")
    @NotEmpty
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(required = true, value = "Description of the area.")
    @NotEmpty
    @JsonProperty("description")
    private String description;

    @ApiModelProperty(required = true, value = "The Theme Park in which the area is located.")
    @NotEmpty
    @JsonProperty("themePark")
    private ThemePark themePark;

}