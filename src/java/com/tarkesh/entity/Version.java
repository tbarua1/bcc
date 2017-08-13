/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.entity;

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
public class Version implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
            private Integer downloads, updates,success,failed;
    private String uri;

    @Override
    public String toString() {
        return "Version{" + "id=" + id + ", downloads=" + downloads + ", updates=" + updates + ", success=" + success + ", failed=" + failed + ", uri=" + uri + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.downloads);
        hash = 89 * hash + Objects.hashCode(this.updates);
        hash = 89 * hash + Objects.hashCode(this.success);
        hash = 89 * hash + Objects.hashCode(this.failed);
        hash = 89 * hash + Objects.hashCode(this.uri);
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
        final Version other = (Version) obj;
        if (!Objects.equals(this.uri, other.uri)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.downloads, other.downloads)) {
            return false;
        }
        if (!Objects.equals(this.updates, other.updates)) {
            return false;
        }
        if (!Objects.equals(this.success, other.success)) {
            return false;
        }
        if (!Objects.equals(this.failed, other.failed)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getUpdates() {
        return updates;
    }

    public void setUpdates(Integer updates) {
        this.updates = updates;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    
}
