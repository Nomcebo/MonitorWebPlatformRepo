/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.monitor.dto;

import com.boha.monitor.data.ProjectSiteTaskStatus;
import java.io.Serializable;
import java.util.Date;

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
    private Integer projectSiteStaffID;

    public ProjectSiteTaskStatusDTO() {
    }

    public ProjectSiteTaskStatusDTO(ProjectSiteTaskStatus a) {
        this.projectSiteTaskStatusID = a.getProjectSiteTaskStatusID();
        this.projectSiteStaffID = a.getProjectSiteStaff().getProjectSiteStaffID();
        this.projectSiteTaskID = a.getProjectSiteTask().getProjectSiteTaskID();
        this.taskStatus = new TaskStatusDTO(a.getTaskStatus());
        this.dateUpdated = a.getDateUpdated().getTime();
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
