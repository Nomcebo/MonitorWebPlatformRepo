/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.monitor.dto;

import com.boha.monitor.data.GcmDevice;


/**
 *
 * @author aubreyM
 */
public class GcmDeviceDTO {

    private Integer gcmDeviceID;
    private String registrationID;
    private String manufacturer;
    private String model;
    private String product;
    private Integer messageCount;
    private long dateRegistered;
    private String serialNumber, androidVersion;
    private Integer companyStaffID, companyID, projectSiteID;
   
    
    public GcmDeviceDTO(GcmDevice a) {
        gcmDeviceID = a.getGcmDeviceID();
        registrationID = a.getRegistrationID();
        manufacturer = a.getManufacturer();
        model = a.getModel();
        product = a.getProduct();
        messageCount = a.getMessageCount();
        dateRegistered =  a.getDateRegistered().getTime();
        serialNumber = a.getSerialNumber();
        if (a.getCompanyStaff()!= null) {
            companyStaffID = a.getCompanyStaff().getCompanyStaffID();
        }
        if (a.getCompany() != null) {
            companyID = a.getCompany().getCompanyID();
        }
        if (a.getProjectSite() != null) {
            projectSiteID = a.getProjectSite().getProjectSiteID();
        }
        androidVersion = a.getAndroidVersion();
        
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public Integer getProjectSiteID() {
        return projectSiteID;
    }

    public void setProjectSiteID(Integer projectSiteID) {
        this.projectSiteID = projectSiteID;
    }

    public Integer getGcmDeviceID() {
        return gcmDeviceID;
    }

    public void setGcmDeviceID(Integer gcmDeviceID) {
        this.gcmDeviceID = gcmDeviceID;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getCompanyStaffID() {
        return companyStaffID;
    }

    public void setCompanyStaffID(Integer companyStaffID) {
        this.companyStaffID = companyStaffID;
    }

}
