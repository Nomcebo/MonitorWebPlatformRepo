/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.monitor.data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "beneficiary")
@NamedQueries({
    @NamedQuery(name = "Beneficiary.findAll", query = "SELECT b FROM Beneficiary b"),
    @NamedQuery(name = "Beneficiary.findByBeneficiaryID", query = "SELECT b FROM Beneficiary b WHERE b.beneficiaryID = :beneficiaryID"),
    @NamedQuery(name = "Beneficiary.findByFirstName", query = "SELECT b FROM Beneficiary b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "Beneficiary.findByLastName", query = "SELECT b FROM Beneficiary b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "Beneficiary.findByMiddleName", query = "SELECT b FROM Beneficiary b WHERE b.middleName = :middleName"),
    @NamedQuery(name = "Beneficiary.findByIDNumber", query = "SELECT b FROM Beneficiary b WHERE b.iDNumber = :iDNumber"),
    @NamedQuery(name = "Beneficiary.findByEmail", query = "SELECT b FROM Beneficiary b WHERE b.email = :email"),
    @NamedQuery(name = "Beneficiary.findByCellphone", query = "SELECT b FROM Beneficiary b WHERE b.cellphone = :cellphone"),
    @NamedQuery(name = "Beneficiary.findByDateRegistered", query = "SELECT b FROM Beneficiary b WHERE b.dateRegistered = :dateRegistered")})
public class Beneficiary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "beneficiaryID")
    private Integer beneficiaryID;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "middleName")
    private String middleName;
    @Size(max = 45)
    @Column(name = "IDNumber")
    private String iDNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @JoinColumn(name = "projectSiteID", referencedColumnName = "projectSiteID")
    @ManyToOne
    private ProjectSite projectSite;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;

    public Beneficiary() {
    }

    public Beneficiary(Integer beneficiaryID) {
        this.beneficiaryID = beneficiaryID;
    }

    public Integer getBeneficiaryID() {
        return beneficiaryID;
    }

    public void setBeneficiaryID(Integer beneficiaryID) {
        this.beneficiaryID = beneficiaryID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getiDNumber() {
        return iDNumber;
    }

    public void setiDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public ProjectSite getProjectSite() {
        return projectSite;
    }

    public void setProjectSite(ProjectSite projectSite) {
        this.projectSite = projectSite;
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
        hash += (beneficiaryID != null ? beneficiaryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiary)) {
            return false;
        }
        Beneficiary other = (Beneficiary) object;
        if ((this.beneficiaryID == null && other.beneficiaryID != null) || (this.beneficiaryID != null && !this.beneficiaryID.equals(other.beneficiaryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.monitor.data.Beneficiary[ beneficiaryID=" + beneficiaryID + " ]";
    }
    
}
