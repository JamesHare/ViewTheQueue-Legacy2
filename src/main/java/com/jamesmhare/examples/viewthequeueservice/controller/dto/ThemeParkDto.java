package com.jamesmhare.examples.viewthequeueservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamesmhare.examples.viewthequeueservice.model.Attraction;
import com.jamesmhare.examples.viewthequeueservice.model.Restaurant;
import com.jamesmhare.examples.viewthequeueservice.model.Show;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@Validated
public class ThemeParkDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private UUID id;
    @ApiModelProperty(required = true, value = "Description of the attraction.")
    @NotEmpty
    @JsonProperty("description")
    private String description;
    @ApiModelProperty(required = true, value = "A list of Attractions.")
    @JsonProperty("attractions")
    private Set<Attraction> attractions;
    @ApiModelProperty(required = true, value = "A list of Restaurants.")
    @JsonProperty("restaurants")
    private Set<Restaurant> restaurants;
    @ApiModelProperty(required = true, value = "A list of Shows.")
    @JsonProperty("shows")
    private Set<Show> shows;

}
