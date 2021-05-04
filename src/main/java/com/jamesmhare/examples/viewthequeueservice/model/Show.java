package com.jamesmhare.examples.viewthequeueservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.Date;

/**
 * Represents a Show in a Theme Park.
 *
 * @author James Hare
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shows")
public class Show extends AbstractViewTheQueueEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private String area;
    @ManyToOne
    @JoinColumn(name="theme_park_id", nullable=false)
    private ThemePark themePark;

}
