/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.monitor.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.findByCompanyProjectName", 
            query = "SELECT p FROM Project p where p.company.companyID = :companyID and p.projectName = :projectName"),
    @NamedQuery(name = "Project.findByCompany", 
            query = "SELECT p FROM Project p WHERE p.company.companyID = :companyID order by p.dateRegistered desc"),
    @NamedQuery(name = "Project.findActiveProjectsByCompany", 
            query = "SELECT p FROM Project p WHERE p.company.companyID = :companyID and (p.completeFlag is null) "
                    + "order by p.dateRegistered desc"),
    
})
public class Project implements Serializable {
    @OneToMany(mappedBy = "project")
    private List<TaskPrice> taskPriceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Beneficiary> beneficiaryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<ProjectEngineer> projectEngineerList;
    @OneToMany(mappedBy = "project")
    private List<ContractorClaim> contractorClaimList;
    @OneToMany(mappedBy = "project")
    private List<PhotoUpload> photoUploadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Invoice> invoiceList;
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    @ManyToOne
    private Client client;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projectID")
    private Integer projectID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "projectName")
    private String projectName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "completeFlag")
    private Integer completeFlag;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<ProjectSite> projectSiteList;

    public Project() {
    }

    public Project(Integer projectID) {
        this.projectID = projectID;
    }

    public Project(Integer projectID, String projectName, Date dateRegistered) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.dateRegistered = dateRegistered;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Integer getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(Integer completeFlag) {
        this.completeFlag = completeFlag;
    }

    public List<ProjectSite> getProjectSiteList() {
        return projectSiteList;
    }

    public void setProjectSiteList(List<ProjectSite> projectSiteList) {
        this.projectSiteList = projectSiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectID != null ? projectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectID == null && other.projectID != null) || (this.projectID != null && !this.projectID.equals(other.projectID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.monitor.data.Project[ projectID=" + projectID + " ]";
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<PhotoUpload> getPhotoUploadList() {
        return photoUploadList;
    }

    public void setPhotoUploadList(List<PhotoUpload> photoUploadList) {
        this.photoUploadList = photoUploadList;
    }

    public List<ContractorClaim> getContractorClaimList() {
        return contractorClaimList;
    }

    public void setContractorClaimList(List<ContractorClaim> contractorClaimList) {
        this.contractorClaimList = contractorClaimList;
    }

    public List<ProjectEngineer> getProjectEngineerList() {
        return projectEngineerList;
    }

    public void setProjectEngineerList(List<ProjectEngineer> projectEngineerList) {
        this.projectEngineerList = projectEngineerList;
    }

    public List<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public void setBeneficiaryList(List<Beneficiary> beneficiaryList) {
        this.beneficiaryList = beneficiaryList;
    }

    public List<TaskPrice> getTaskPriceList() {
        return taskPriceList;
    }

    public void setTaskPriceList(List<TaskPrice> taskPriceList) {
        this.taskPriceList = taskPriceList;
    }

    
}
