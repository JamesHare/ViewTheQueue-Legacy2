package com.jamesmhare.examples.viewthequeueservice.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Represents an Attraction in a Theme Park.
 *
 * @author James Hare
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attractions")
public class Attraction extends AbstractViewTheQueueEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private String area;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer waitTime;
    @Column(nullable = false)
    private Integer maxHeightRestrictionInches;
    @Column(nullable = false)
    private Integer minHeightRestrictionInches;
    @Column(nullable = false)
    private boolean hasExpressLine;
    @Column(nullable = false)
    private boolean hasSingleRider;
    @ManyToOne
    @JoinColumn(name="theme_park_id", nullable=false)
    private ThemePark themePark;

}