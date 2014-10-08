/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.monitor.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "checkPoint")
@NamedQueries({
    @NamedQuery(name = "CheckPoint.findAll", query = "SELECT c FROM CheckPoint c"),
    @NamedQuery(name = "CheckPoint.findByCheckPointID", query = "SELECT c FROM CheckPoint c WHERE c.checkPointID = :checkPointID"),
    @NamedQuery(name = "CheckPoint.findByCheckPointName", query = "SELECT c FROM CheckPoint c WHERE c.checkPointName = :checkPointName")})
public class CheckPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "checkPointID")
    private Integer checkPointID;
    @Size(max = 255)
    @Column(name = "checkPointName")
    private String checkPointName;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;

    public CheckPoint() {
    }

    public CheckPoint(Integer checkPointID) {
        this.checkPointID = checkPointID;
    }

    public Integer getCheckPointID() {
        return checkPointID;
    }

    public void setCheckPointID(Integer checkPointID) {
        this.checkPointID = checkPointID;
    }

    public String getCheckPointName() {
        return checkPointName;
    }

    public void setCheckPointName(String checkPointName) {
        this.checkPointName = checkPointName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkPointID != null ? checkPointID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckPoint)) {
            return false;
        }
        CheckPoint other = (CheckPoint) object;
        if ((this.checkPointID == null && other.checkPointID != null) || (this.checkPointID != null && !this.checkPointID.equals(other.checkPointID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.monitor.data.CheckPoint[ checkPointID=" + checkPointID + " ]";
    }
    
}
