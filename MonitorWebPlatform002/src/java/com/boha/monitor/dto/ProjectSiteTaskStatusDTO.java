/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.monitor.dto;

import com.boha.monitor.data.CompanyStaff;
import com.boha.monitor.data.ProjectSiteStaff;
import com.boha.monitor.data.ProjectSiteTask;
import com.boha.monitor.data.ProjectSiteTaskStatus;
import java.io.Serializable;

/**
 *
 * @author aubreyM
 */
public class ProjectSiteTaskStatusDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer projectSiteTaskStatusID;
    private long dateUpdated;
    private TaskStatusDTO taskStatus;
    private Integer projectSiteTaskID;
    private Integer projectSiteStaffID, companyStaffID;
    private String projectSiteName, projectName, staffName;

    public ProjectSiteTaskStatusDTO() {
    }

    public ProjectSiteTaskStatusDTO(ProjectSiteTaskStatus a) {
        this.projectSiteTaskStatusID = a.getProjectSiteTaskStatusID();
        ProjectSiteTask pst = a.getProjectSiteTask();
        this.projectSiteName = pst.getProjectSite().getProjectSiteName();
        this.projectSiteTaskID = pst.getProjectSiteTaskID();
        this.taskStatus = new TaskStatusDTO(a.getTaskStatus());
        this.dateUpdated = a.getDateUpdated().getTime();
        ProjectSiteStaff s = a.getProjectSiteStaff();
        CompanyStaff cs = s.getCompanyStaff();
        this.companyStaffID = cs.getCompanyStaffID();
        this.staffName = cs.getFirstName() + " " + cs.getLastName();
        this.projectSiteStaffID = s.getProjectSiteStaffID();
    }

    public Integer getCompanyStaffID() {
        return companyStaffID;
    }

    public void setCompanyStaffID(Integer companyStaffID) {
        this.companyStaffID = companyStaffID;
    }

    public String getProjectSiteName() {
        return projectSiteName;
    }

    public void setProjectSiteName(String projectSiteName) {
        this.projectSiteName = projectSiteName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

   

    public Integer getProjectSiteTaskStatusID() {
        return projectSiteTaskStatusID;
    }

    public void setProjectSiteTaskStatusID(Integer projectSiteTaskStatusID) {
        this.projectSiteTaskStatusID = projectSiteTaskStatusID;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

   

    public TaskStatusDTO getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatusDTO taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getProjectSiteTaskID() {
        return projectSiteTaskID;
    }

    public void setProjectSiteTaskID(Integer projectSiteTaskID) {
        this.projectSiteTaskID = projectSiteTaskID;
    }

    public Integer getProjectSiteStaffID() {
        return projectSiteStaffID;
    }

    public void setProjectSiteStaffID(Integer projectSiteStaffID) {
        this.projectSiteStaffID = projectSiteStaffID;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectSiteTaskStatusID != null ? projectSiteTaskStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectSiteTaskStatusDTO)) {
            return false;
        }
        ProjectSiteTaskStatusDTO other = (ProjectSiteTaskStatusDTO) object;
        if ((this.projectSiteTaskStatusID == null && other.projectSiteTaskStatusID != null) || (this.projectSiteTaskStatusID != null && !this.projectSiteTaskStatusID.equals(other.projectSiteTaskStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.monitor.data.ProjectSiteTaskStatus[ projectSiteTaskStatusID=" + projectSiteTaskStatusID + " ]";
    }
    
}
