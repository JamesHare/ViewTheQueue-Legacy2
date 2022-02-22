package com.jamesmhare.examples.viewthequeueservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents an Attraction in a Theme Park.
 *
 * @author James Hare
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attractions")
public class Attraction extends AbstractTimestampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long attractionId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private OperatingStatus operatingStatus;

    @Column(nullable = false)
    private Date openingTime;

    @Column(nullable = false)
    private Date closingTime;

    @Column(nullable = false)
    private Long waitTime;

    @Column(nullable = false)
    private Integer maxHeightInches;

    @Column(nullable = false)
    private Integer minHeightInches;

    @Column(name = "express_line", nullable = false)
    private boolean hasExpressLine;

    @Column(name = "single_rider_line", nullable = false)
    private boolean hasSingleRiderLine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "areas_to_attractions",
            joinColumns = @JoinColumn(name = "attraction_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    private Area area;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "theme_parks_to_attractions",
            joinColumns = @JoinColumn(name = "attraction_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_park_id"))
    private ThemePark themePark;

}