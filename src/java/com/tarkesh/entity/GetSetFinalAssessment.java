package com.tarkesh.entity;


import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tarkeshwar
 */
public class GetSetFinalAssessment {
    private Number total,male,female;

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }

    public Number getMale() {
        return male;
    }

    public void setMale(Number male) {
        this.male = male;
    }

    public Number getFemale() {
        return female;
    }

    public void setFemale(Number female) {
        this.female = female;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.total);
        hash = 89 * hash + Objects.hashCode(this.male);
        hash = 89 * hash + Objects.hashCode(this.female);
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
        final GetSetFinalAssessment other = (GetSetFinalAssessment) obj;
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.male, other.male)) {
            return false;
        }
        if (!Objects.equals(this.female, other.female)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GetSetFinalAssessment{" + "total=" + total + ", male=" + male + ", female=" + female + '}';
    }
    
}
