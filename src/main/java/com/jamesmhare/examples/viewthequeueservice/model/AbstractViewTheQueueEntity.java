package com.jamesmhare.examples.viewthequeueservice.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Provides base entity functionality to ensure timestamps are part of table entries.
 *
 * @author James Hare
 */
@Data
@MappedSuperclass
public abstract class AbstractViewTheQueueEntity {

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
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdate;

}