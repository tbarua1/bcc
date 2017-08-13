package com.tarkesh.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BatchSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   @Temporal(TemporalType.TIMESTAMP)  
    
    private Calendar date;
   @Temporal(TemporalType.TIMESTAMP)
    private Calendar till;
// @Temporal(TemporalType.TIMESTAMP)
//  private Date time;
    private String Status, trainer, batchcode, comment, university, program, facebookURL, location, department, spoc_university, contact, ey_spoc, ey_contact, local_spoc, local_phone, track, schedule;
private int startAttendence, endAttendence;

    public int getStartAttendence() {
        return startAttendence;
    }

    public void setStartAttendence(int startAttendence) {
        this.startAttendence = startAttendence;
    }

    public int getEndAttendence() {
        return endAttendence;
    }

    public void setEndAttendence(int endAttendence) {
        this.endAttendence = endAttendence;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
   
    public Calendar getTill() {
        return till;
    }

    public void setTill(Calendar till) {
        this.till = till;
    }

    
    @Override
    public String toString() {
        return "BatchSchedule{" + "id=" + id + ", date=" + date + ", till=" + till + ", Status=" + Status + ", trainer=" + trainer + ", batchcode=" + batchcode + ", comment=" + comment + ", university=" + university + ", program=" + program + ", facebookURL=" + facebookURL + ", location=" + location + ", department=" + department + ", spoc_university=" + spoc_university + ", contact=" + contact + ", ey_spoc=" + ey_spoc + ", ey_contact=" + ey_contact + ", local_spoc=" + local_spoc + ", local_phone=" + local_phone + ", track=" + track + ", schedule=" + schedule + '}';
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.date);
        hash = 89 * hash + Objects.hashCode(this.till);
        hash = 89 * hash + Objects.hashCode(this.Status);
        hash = 89 * hash + Objects.hashCode(this.trainer);
        hash = 89 * hash + Objects.hashCode(this.batchcode);
        hash = 89 * hash + Objects.hashCode(this.comment);
        hash = 89 * hash + Objects.hashCode(this.university);
        hash = 89 * hash + Objects.hashCode(this.program);
        hash = 89 * hash + Objects.hashCode(this.facebookURL);
        hash = 89 * hash + Objects.hashCode(this.location);
        hash = 89 * hash + Objects.hashCode(this.department);
        hash = 89 * hash + Objects.hashCode(this.spoc_university);
        hash = 89 * hash + Objects.hashCode(this.contact);
        hash = 89 * hash + Objects.hashCode(this.ey_spoc);
        hash = 89 * hash + Objects.hashCode(this.ey_contact);
        hash = 89 * hash + Objects.hashCode(this.local_spoc);
        hash = 89 * hash + Objects.hashCode(this.local_phone);
        hash = 89 * hash + Objects.hashCode(this.track);
        hash = 89 * hash + Objects.hashCode(this.schedule);
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
        final BatchSchedule other = (BatchSchedule) obj;
        if (!Objects.equals(this.Status, other.Status)) {
            return false;
        }
        if (!Objects.equals(this.trainer, other.trainer)) {
            return false;
        }
        if (!Objects.equals(this.batchcode, other.batchcode)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.university, other.university)) {
            return false;
        }
        if (!Objects.equals(this.program, other.program)) {
            return false;
        }
        if (!Objects.equals(this.facebookURL, other.facebookURL)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.department, other.department)) {
            return false;
        }
        if (!Objects.equals(this.spoc_university, other.spoc_university)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.ey_spoc, other.ey_spoc)) {
            return false;
        }
        if (!Objects.equals(this.ey_contact, other.ey_contact)) {
            return false;
        }
        if (!Objects.equals(this.local_spoc, other.local_spoc)) {
            return false;
        }
        if (!Objects.equals(this.local_phone, other.local_phone)) {
            return false;
        }
        if (!Objects.equals(this.track, other.track)) {
            return false;
        }
        if (!Objects.equals(this.schedule, other.schedule)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.till, other.till)) {
            return false;
        }
        return true;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Date getTill() {
//        return till;
//    }
//
//    public void setTill(Date till) {
//        this.till = till;
//    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getBatchcode() {
        return batchcode;
    }

    public void setBatchcode(String batchcode) {
        this.batchcode = batchcode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(String facebookURL) {
        this.facebookURL = facebookURL;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpoc_university() {
        return spoc_university;
    }

    public void setSpoc_university(String spoc_university) {
        this.spoc_university = spoc_university;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEy_spoc() {
        return ey_spoc;
    }

    public void setEy_spoc(String ey_spoc) {
        this.ey_spoc = ey_spoc;
    }

    public String getEy_contact() {
        return ey_contact;
    }

    public void setEy_contact(String ey_contact) {
        this.ey_contact = ey_contact;
    }

    public String getLocal_spoc() {
        return local_spoc;
    }

    public void setLocal_spoc(String local_spoc) {
        this.local_spoc = local_spoc;
    }

    public String getLocal_phone() {
        return local_phone;
    }

    public void setLocal_phone(String local_phone) {
        this.local_phone = local_phone;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

  
}
