package com.tarkesh.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tarkeshwar
 */
@Entity
public class FinalAssessment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String Module_topup_softskill,location;
private int totalNASSCOMComplete,male,female;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule_topup_softskill() {
        return Module_topup_softskill;
    }

    public void setModule_topup_softskill(String Module_topup_softskill) {
        this.Module_topup_softskill = Module_topup_softskill;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalNASSCOMComplete() {
        return totalNASSCOMComplete;
    }

    public void setTotalNASSCOMComplete(int totalNASSCOMComplete) {
        this.totalNASSCOMComplete = totalNASSCOMComplete;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.Module_topup_softskill);
        hash = 23 * hash + Objects.hashCode(this.location);
        hash = 23 * hash + this.totalNASSCOMComplete;
        hash = 23 * hash + this.male;
        hash = 23 * hash + this.female;
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
        final FinalAssessment other = (FinalAssessment) obj;
        if (this.totalNASSCOMComplete != other.totalNASSCOMComplete) {
            return false;
        }
        if (this.male != other.male) {
            return false;
        }
        if (this.female != other.female) {
            return false;
        }
        if (!Objects.equals(this.Module_topup_softskill, other.Module_topup_softskill)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FinalAssessment{" + "id=" + id + ", Module_topup_softskill=" + Module_topup_softskill + ", location=" + location + ", totalNASSCOMComplete=" + totalNASSCOMComplete + ", male=" + male + ", female=" + female + '}';
    }

  
    
}
