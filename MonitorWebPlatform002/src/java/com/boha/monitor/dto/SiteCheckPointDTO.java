/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.monitor.dto;

import com.boha.monitor.data.SiteCheckPoint;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aubreyM
 */
public class SiteCheckPointDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer siteCheckPointID;
    private CheckPointDTO checkPoint;
    private Date dateRegistered;
    private InvoiceDTO invoice;
    private ProjectSiteDTO projectSite;

    public SiteCheckPointDTO() {
    }

    public SiteCheckPointDTO(Integer siteCheckPointID) {
        this.siteCheckPointID = siteCheckPointID;
    }

    public SiteCheckPointDTO(SiteCheckPoint a) {
        this.siteCheckPointID = a.getSiteCheckPointID();
        this.checkPoint = new CheckPointDTO(a.getCheckPoint());
        this.invoice = new InvoiceDTO(a.getInvoice());
        this.dateRegistered = a.getDateRegistered();
    }

    public Integer getSiteCheckPointID() {
        return siteCheckPointID;
    }

    public void setSiteCheckPointID(Integer siteCheckPointID) {
        this.siteCheckPointID = siteCheckPointID;
    }

    public CheckPointDTO getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(CheckPointDTO checkPoint) {
        this.checkPoint = checkPoint;
    }


    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }

    public ProjectSiteDTO getProjectSite() {
        return projectSite;
    }

    public void setProjectSite(ProjectSiteDTO projectSite) {
        this.projectSite = projectSite;
    }

}
