package com.jamesmhare.examples.viewthequeueservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a Show in a Theme Park.
 *
 * @author James Hare
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shows")
public class Show extends AbstractTimestampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long showId;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "areas_to_shows",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    private Area area;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "theme_parks_to_shows",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_park_id"))
    private ThemePark themePark;

}
