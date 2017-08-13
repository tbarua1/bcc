package com.tarkesh.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tarkeshwar
 */
@Entity
public class PlacementOpportunities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String program,contact_person,contact_number,
opportunity_name, organization_name,  forcast_closing_date,current_status_next_step;

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
private int resource_requirement;
 @Temporal(TemporalType.TIMESTAMP)    
    private Date date;

    public int getResource_requirement() {
        return resource_requirement;
    }

    public void setResource_requirement(int resource_requirement) {
        this.resource_requirement = resource_requirement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
 
    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }
    

public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpportunity_name() {
        return opportunity_name;
    }

    public void setOpportunity_name(String opportunity_name) {
        this.opportunity_name = opportunity_name;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

   
    public String getForcast_closing_date() {
        return forcast_closing_date;
    }

    public void setForcast_closing_date(String forcast_closing_date) {
        this.forcast_closing_date = forcast_closing_date;
    }

    public String getCurrent_status_next_step() {
        return current_status_next_step;
    }

    public void setCurrent_status_next_step(String current_status_next_step) {
        this.current_status_next_step = current_status_next_step;
    }

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.opportunity_name);
        hash = 97 * hash + Objects.hashCode(this.organization_name);
        hash = 97 * hash + Objects.hashCode(this.resource_requirement);
        hash = 97 * hash + Objects.hashCode(this.forcast_closing_date);
        hash = 97 * hash + Objects.hashCode(this.current_status_next_step);
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlacementOpportunities other = (PlacementOpportunities) obj;
        if (!Objects.equals(this.opportunity_name, other.opportunity_name)) {
            return false;
        }
        if (!Objects.equals(this.organization_name, other.organization_name)) {
            return false;
        }
        if (!Objects.equals(this.resource_requirement, other.resource_requirement)) {
            return false;
        }
        if (!Objects.equals(this.forcast_closing_date, other.forcast_closing_date)) {
            return false;
        }
        if (!Objects.equals(this.current_status_next_step, other.current_status_next_step)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlacementOpportunities{" + "id=" + id + ", opportunity_name=" + opportunity_name + ", organization_name=" + organization_name + ", resource_requirement=" + resource_requirement + ", forcast_closing_date=" + forcast_closing_date + ", current_status_next_step=" + current_status_next_step + ", date=" + date + '}';
    }

 
    
}
