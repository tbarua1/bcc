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
public class GetSetPlacementGraph {
    private Number TOPUP,ITES;

    public Number getTOPUP() {
        return TOPUP;
    }

    public void setTOPUP(Number TOPUP) {
        this.TOPUP = TOPUP;
    }

    public Number getITES() {
        return ITES;
    }

    public void setITES(Number ITES) {
        this.ITES = ITES;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.TOPUP);
        hash = 97 * hash + Objects.hashCode(this.ITES);
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
        final GetSetPlacementGraph other = (GetSetPlacementGraph) obj;
        if (!Objects.equals(this.TOPUP, other.TOPUP)) {
            return false;
        }
        if (!Objects.equals(this.ITES, other.ITES)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlacementGraph{" + "TOPUP=" + TOPUP + ", ITES=" + ITES + '}';
    }
  
}
