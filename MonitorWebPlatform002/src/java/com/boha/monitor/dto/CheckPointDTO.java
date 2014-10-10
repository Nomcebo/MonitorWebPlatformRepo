/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.monitor.dto;

import com.boha.monitor.data.*;
import java.io.Serializable;

/**
 *
 * @author aubreyM
 */
public class CheckPointDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer checkPointID;
    private String checkPointName, description;
    private CompanyDTO company;

    public CheckPointDTO(CheckPoint a) {
        checkPointID = a.getCheckPointID();
        checkPointName = a.getCheckPointName();
        description = a.getDescription();
        company = new CompanyDTO(a.getCompany());
    }

    public CheckPointDTO(Integer checkPointID) {
        this.checkPointID = checkPointID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

  
    
}
