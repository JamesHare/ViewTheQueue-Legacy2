package com.jamesmhare.examples.viewthequeueservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a Theme Park.
 *
 * @author James Hare
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "theme_parks")
public class ThemePark extends AbstractViewTheQueueEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy="theme_park")
    private Set<Attraction> attractions;
    @OneToMany(mappedBy="theme_park")
    private Set<Restaurant> restaurants;
    @OneToMany(mappedBy="theme_park")
    private Set<Show> shows;

}
