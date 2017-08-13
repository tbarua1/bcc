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
public class GetSetTopup {
    private Number completed,ongoing,scheduled,projected;

    public Number getCompleted() {
        return completed;
    }

    public void setCompleted(Number completed) {
        this.completed = completed;
    }

    public Number getOngoing() {
        return ongoing;
    }

    public void setOngoing(Number ongoing) {
        this.ongoing = ongoing;
    }

    public Number getScheduled() {
        return scheduled;
    }

    public void setScheduled(Number scheduled) {
        this.scheduled = scheduled;
    }

    public Number getProjected() {
        return projected;
    }

    public void setProjected(Number projected) {
        this.projected = projected;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.completed);
        hash = 19 * hash + Objects.hashCode(this.ongoing);
        hash = 19 * hash + Objects.hashCode(this.scheduled);
        hash = 19 * hash + Objects.hashCode(this.projected);
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
        final GetSetTopup other = (GetSetTopup) obj;
        if (!Objects.equals(this.completed, other.completed)) {
            return false;
        }
        if (!Objects.equals(this.ongoing, other.ongoing)) {
            return false;
        }
        if (!Objects.equals(this.scheduled, other.scheduled)) {
            return false;
        }
        if (!Objects.equals(this.projected, other.projected)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GetSetTopup{" + "completed=" + completed + ", ongoing=" + ongoing + ", scheduled=" + scheduled + ", projected=" + projected + '}';
    }

   
}
