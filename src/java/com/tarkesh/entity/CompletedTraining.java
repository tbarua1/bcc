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
public class CompletedTraining implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number_of_students_trained;
private String division, university, program_type, department, completing_year_month_academic, track, training, completing_year,_month_academic,  date;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getProgram_type() {
        return program_type;
    }

    public void setProgram_type(String program_type) {
        this.program_type = program_type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompleting_year_month_academic() {
        return completing_year_month_academic;
    }

    public void setCompleting_year_month_academic(String completing_year_month_academic) {
        this.completing_year_month_academic = completing_year_month_academic;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getCompleting_year() {
        return completing_year;
    }

    public void setCompleting_year(String completing_year) {
        this.completing_year = completing_year;
    }

    public String getMonth_academic() {
        return _month_academic;
    }

    public void setMonth_academic(String _month_academic) {
        this._month_academic = _month_academic;
    }

    public int getNumber_of_students_trained() {
        return number_of_students_trained;
    }

    public void setNumber_of_students_trained(int number_of_students_trained) {
        this.number_of_students_trained = number_of_students_trained;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.division);
        hash = 79 * hash + Objects.hashCode(this.university);
        hash = 79 * hash + Objects.hashCode(this.program_type);
        hash = 79 * hash + Objects.hashCode(this.department);
        hash = 79 * hash + Objects.hashCode(this.completing_year_month_academic);
        hash = 79 * hash + Objects.hashCode(this.track);
        hash = 79 * hash + Objects.hashCode(this.training);
        hash = 79 * hash + Objects.hashCode(this.completing_year);
        hash = 79 * hash + Objects.hashCode(this._month_academic);
        hash = 79 * hash + Objects.hashCode(this.number_of_students_trained);
        hash = 79 * hash + Objects.hashCode(this.date);
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
        final CompletedTraining other = (CompletedTraining) obj;
        if (!Objects.equals(this.division, other.division)) {
            return false;
        }
        if (!Objects.equals(this.university, other.university)) {
            return false;
        }
        if (!Objects.equals(this.program_type, other.program_type)) {
            return false;
        }
        if (!Objects.equals(this.department, other.department)) {
            return false;
        }
        if (!Objects.equals(this.completing_year_month_academic, other.completing_year_month_academic)) {
            return false;
        }
        if (!Objects.equals(this.track, other.track)) {
            return false;
        }
        if (!Objects.equals(this.training, other.training)) {
            return false;
        }
        if (!Objects.equals(this.completing_year, other.completing_year)) {
            return false;
        }
        if (!Objects.equals(this._month_academic, other._month_academic)) {
            return false;
        }
        if (!Objects.equals(this.number_of_students_trained, other.number_of_students_trained)) {
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
        return "CompetedTraining{" + "id=" + id + ", division=" + division + ", university=" + university + ", program_type=" + program_type + ", department=" + department + ", completing_year_month_academic=" + completing_year_month_academic + ", track=" + track + ", training=" + training + ", completing_year=" + completing_year + ", _month_academic=" + _month_academic + ", number_of_students_trained=" + number_of_students_trained + ", date=" + date + '}';
    }


    
}
