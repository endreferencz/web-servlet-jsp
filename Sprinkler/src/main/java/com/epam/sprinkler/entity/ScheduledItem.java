package com.epam.sprinkler.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ScheduledItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;

    @Temporal(TemporalType.TIMESTAMP)
    private Date to;
    
    @ManyToOne
    private Zone zone;
    
    private boolean recurring;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Date getFrom() {
        return new Date(from.getTime());
    }

    public void setFrom(final Date from) {
        this.from = new Date(from.getTime());
    }

    public Date getTo() {
        return new Date(to.getTime());
    }

    public void setTo(final Date to) {
        this.to = new Date(to.getTime());
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(final Zone zone) {
        this.zone = zone;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(final boolean recurring) {
        this.recurring = recurring;
    }

}
