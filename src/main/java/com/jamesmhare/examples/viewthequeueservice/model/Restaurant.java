package com.jamesmhare.examples.viewthequeueservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a Restaurant in a Theme Park.
 *
 * @author James Hare
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurants")
public class Restaurant extends AbstractTimestampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long restaurantId;

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
    private boolean servesVegetarian;

    @Column(nullable = false)
    private boolean servesVegan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "areas_to_restaurants",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    private Area area;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "theme_parks_to_restaurants",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_park_id"))
    private ThemePark themePark;

}
