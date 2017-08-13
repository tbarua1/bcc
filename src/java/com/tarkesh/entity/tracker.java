package com.tarkesh.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 *
 * @author tarkeshwar
 */
@Entity
@JsonIgnoreProperties
public class tracker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    @Temporal(TemporalType.TIMESTAMP)    
    private Date batch_start_date;
    private int taken_minute,taken_second,taken_hour,batch_size_on_start_date, existing_batch_size_on_date, dropout_on_date, 
            male, female,hours_completed_trainer, hours_completed_domain_trainer;
    private String comment,division,start_time,end_time,status, batch_code, tool_id, university, location, ey_spoc, phone_ey_spoc,
            local_spoc, phone_local_spoc, department, track,trainer_name, domain_trainer_name, expected_end_month, academic_year_closer_month_year, module_topup_softskill, date;
    private double lattitude,longitude;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLattitude() {
        return lattitude;
    }
public Date getBatch_start_date() {
        return batch_start_date;
    }

    public void setBatch_start_date(Date batch_start_date) {
        this.batch_start_date = batch_start_date;
    }
    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getTaken_minute() {
        return taken_minute;
    }

    public void setTaken_minute(int taken_minute) {
        this.taken_minute = taken_minute;
    }

    public int getTaken_second() {
        return taken_second;
    }

    public void setTaken_second(int taken_second) {
        this.taken_second = taken_second;
    }

    public int getTaken_hour() {
        return taken_hour;
    }

    public void setTaken_hour(int taken_hour) {
        this.taken_hour = taken_hour;
    }

    public int getBatch_size_on_start_date() {
        return batch_size_on_start_date;
    }

    public void setBatch_size_on_start_date(int batch_size_on_start_date) {
        this.batch_size_on_start_date = batch_size_on_start_date;
    }

    public int getExisting_batch_size_on_date() {
        return existing_batch_size_on_date;
    }

    public void setExisting_batch_size_on_date(int existing_batch_size_on_date) {
        this.existing_batch_size_on_date = existing_batch_size_on_date;
    }

    public int getDropout_on_date() {
        return dropout_on_date;
    }

    public void setDropout_on_date(int dropout_on_date) {
        this.dropout_on_date = dropout_on_date;
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

    public int getHours_completed_trainer() {
        return hours_completed_trainer;
    }

    public void setHours_completed_trainer(int hours_completed_trainer) {
        this.hours_completed_trainer = hours_completed_trainer;
    }

    public int getHours_completed_domain_trainer() {
        return hours_completed_domain_trainer;
    }

    public void setHours_completed_domain_trainer(int hours_completed_domain_trainer) {
        this.hours_completed_domain_trainer = hours_completed_domain_trainer;
    }

    
    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBatch_code() {
        return batch_code;
    }

    public void setBatch_code(String batch_code) {
        this.batch_code = batch_code;
    }

    public String getTool_id() {
        return tool_id;
    }

    public void setTool_id(String tool_id) {
        this.tool_id = tool_id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEy_spoc() {
        return ey_spoc;
    }

    public void setEy_spoc(String ey_spoc) {
        this.ey_spoc = ey_spoc;
    }

    public String getPhone_ey_spoc() {
        return phone_ey_spoc;
    }

    public void setPhone_ey_spoc(String phone_ey_spoc) {
        this.phone_ey_spoc = phone_ey_spoc;
    }

    public String getLocal_spoc() {
        return local_spoc;
    }

    public void setLocal_spoc(String local_spoc) {
        this.local_spoc = local_spoc;
    }

    public String getPhone_local_spoc() {
        return phone_local_spoc;
    }

    public void setPhone_local_spoc(String phone_local_spoc) {
        this.phone_local_spoc = phone_local_spoc;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

//    public String getBatch_start_date() {
//        return batch_start_date;
//    }
//
//    public void setBatch_start_date(String batch_start_date) {
//        this.batch_start_date = batch_start_date;
//    }

    public String getTrainer_name() {
        return trainer_name;
    }

    public void setTrainer_name(String trainer_name) {
        this.trainer_name = trainer_name;
    }

    public String getDomain_trainer_name() {
        return domain_trainer_name;
    }

    public void setDomain_trainer_name(String domain_trainer_name) {
        this.domain_trainer_name = domain_trainer_name;
    }

    public String getExpected_end_month() {
        return expected_end_month;
    }

    public void setExpected_end_month(String expected_end_month) {
        this.expected_end_month = expected_end_month;
    }

    public String getAcademic_year_closer_month_year() {
        return academic_year_closer_month_year;
    }

    public void setAcademic_year_closer_month_year(String academic_year_closer_month_year) {
        this.academic_year_closer_month_year = academic_year_closer_month_year;
    }

    public String getModule_topup_softskill() {
        return module_topup_softskill;
    }

    public void setModule_topup_softskill(String module_topup_softskill) {
        this.module_topup_softskill = module_topup_softskill;
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
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + this.taken_minute;
        hash = 37 * hash + this.taken_second;
        hash = 37 * hash + this.taken_hour;
        hash = 37 * hash + this.batch_size_on_start_date;
        hash = 37 * hash + this.existing_batch_size_on_date;
        hash = 37 * hash + this.dropout_on_date;
        hash = 37 * hash + this.male;
        hash = 37 * hash + this.female;
        hash = 37 * hash + this.hours_completed_trainer;
        hash = 37 * hash + this.hours_completed_domain_trainer;
        hash = 37 * hash + Objects.hashCode(this.division);
        hash = 37 * hash + Objects.hashCode(this.start_time);
        hash = 37 * hash + Objects.hashCode(this.end_time);
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + Objects.hashCode(this.batch_code);
        hash = 37 * hash + Objects.hashCode(this.tool_id);
        hash = 37 * hash + Objects.hashCode(this.university);
        hash = 37 * hash + Objects.hashCode(this.location);
        hash = 37 * hash + Objects.hashCode(this.ey_spoc);
        hash = 37 * hash + Objects.hashCode(this.phone_ey_spoc);
        hash = 37 * hash + Objects.hashCode(this.local_spoc);
        hash = 37 * hash + Objects.hashCode(this.phone_local_spoc);
        hash = 37 * hash + Objects.hashCode(this.department);
        hash = 37 * hash + Objects.hashCode(this.track);
        hash = 37 * hash + Objects.hashCode(this.batch_start_date);
        hash = 37 * hash + Objects.hashCode(this.trainer_name);
        hash = 37 * hash + Objects.hashCode(this.domain_trainer_name);
        hash = 37 * hash + Objects.hashCode(this.expected_end_month);
        hash = 37 * hash + Objects.hashCode(this.academic_year_closer_month_year);
        hash = 37 * hash + Objects.hashCode(this.module_topup_softskill);
        hash = 37 * hash + Objects.hashCode(this.date);
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
        final tracker other = (tracker) obj;
        if (this.taken_minute != other.taken_minute) {
            return false;
        }
        if (this.taken_second != other.taken_second) {
            return false;
        }
        if (this.taken_hour != other.taken_hour) {
            return false;
        }
        if (this.batch_size_on_start_date != other.batch_size_on_start_date) {
            return false;
        }
        if (this.existing_batch_size_on_date != other.existing_batch_size_on_date) {
            return false;
        }
        if (this.dropout_on_date != other.dropout_on_date) {
            return false;
        }
        if (this.male != other.male) {
            return false;
        }
        if (this.female != other.female) {
            return false;
        }
        if (this.hours_completed_trainer != other.hours_completed_trainer) {
            return false;
        }
        if (this.hours_completed_domain_trainer != other.hours_completed_domain_trainer) {
            return false;
        }
        if (!Objects.equals(this.division, other.division)) {
            return false;
        }
        if (!Objects.equals(this.start_time, other.start_time)) {
            return false;
        }
        if (!Objects.equals(this.end_time, other.end_time)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.batch_code, other.batch_code)) {
            return false;
        }
        if (!Objects.equals(this.tool_id, other.tool_id)) {
            return false;
        }
        if (!Objects.equals(this.university, other.university)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.ey_spoc, other.ey_spoc)) {
            return false;
        }
        if (!Objects.equals(this.phone_ey_spoc, other.phone_ey_spoc)) {
            return false;
        }
        if (!Objects.equals(this.local_spoc, other.local_spoc)) {
            return false;
        }
        if (!Objects.equals(this.phone_local_spoc, other.phone_local_spoc)) {
            return false;
        }
        if (!Objects.equals(this.department, other.department)) {
            return false;
        }
        if (!Objects.equals(this.track, other.track)) {
            return false;
        }
        if (!Objects.equals(this.batch_start_date, other.batch_start_date)) {
            return false;
        }
        if (!Objects.equals(this.trainer_name, other.trainer_name)) {
            return false;
        }
        if (!Objects.equals(this.domain_trainer_name, other.domain_trainer_name)) {
            return false;
        }
        if (!Objects.equals(this.expected_end_month, other.expected_end_month)) {
            return false;
        }
        if (!Objects.equals(this.academic_year_closer_month_year, other.academic_year_closer_month_year)) {
            return false;
        }
        if (!Objects.equals(this.module_topup_softskill, other.module_topup_softskill)) {
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
        return "Tracker{" + "id=" + id + ", taken_minute=" + taken_minute + ", taken_second=" + taken_second + ", taken_hour=" + taken_hour + ", batch_size_on_start_date=" + batch_size_on_start_date + ", existing_batch_size_on_date=" + existing_batch_size_on_date + ", dropout_on_date=" + dropout_on_date + ", male=" + male + ", female=" + female + ", hours_completed_trainer=" + hours_completed_trainer + ", hours_completed_domain_trainer=" + hours_completed_domain_trainer + ", didision=" + division + ", start_time=" + start_time + ", end_time=" + end_time + ", status=" + status + ", batch_code=" + batch_code + ", tool_id=" + tool_id + ", university=" + university + ", location=" + location + ", ey_spoc=" + ey_spoc + ", phone_ey_spoc=" + phone_ey_spoc + ", local_spoc=" + local_spoc + ", phone_local_spoc=" + phone_local_spoc + ", department=" + department + ", track=" + track + ", batch_start_date=" + batch_start_date + ", trainer_name=" + trainer_name + ", domain_trainer_name=" + domain_trainer_name + ", expected_end_month=" + expected_end_month + ", academic_year_closer_month_year=" + academic_year_closer_month_year + ", module_topup_softskill=" + module_topup_softskill + ", date=" + date + '}';
    }

   
}
