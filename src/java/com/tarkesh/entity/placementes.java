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
public class placementes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number_of_students;
    private String organization_name, program, date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_placement;

    public Long getId() {
        return id;
    }

    public Date getDate_placement() {
        return date_placement;
    }

    public void setDate_placement(Date date_placement) {
        this.date_placement = date_placement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public int getNumber_of_students() {
        return number_of_students;
    }

    public void setNumber_of_students(int number_of_students) {
        this.number_of_students = number_of_students;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.organization_name);
        hash = 59 * hash + Objects.hashCode(this.number_of_students);
        hash = 59 * hash + Objects.hashCode(this.program);
        hash = 59 * hash + Objects.hashCode(this.date);
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
        final placementes other = (placementes) obj;
        if (!Objects.equals(this.organization_name, other.organization_name)) {
            return false;
        }
        if (!Objects.equals(this.number_of_students, other.number_of_students)) {
            return false;
        }
        if (!Objects.equals(this.program, other.program)) {
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
        return "placementes{" + "id=" + id + ", number_of_students=" + number_of_students + ", organization_name=" + organization_name + ", program=" + program + ", date=" + date + ", date_placement=" + date_placement + '}';
    }

}
