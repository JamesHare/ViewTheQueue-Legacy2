package com.jamesmhare.examples.viewthequeueservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a Theme Park.
 *
 * @author James Hare
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "theme_parks")
public class ThemePark extends AbstractTimestampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long themeParkId;

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

}
