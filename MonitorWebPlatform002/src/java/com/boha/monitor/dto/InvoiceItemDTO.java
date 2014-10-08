/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.monitor.dto;

import java.io.Serializable;

/**
 *
 * @author aubreyM
 */
public class InvoiceItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer invoiceItemID;
    private String description;
    private Integer quantity;
    private Double amount;
    private InvoiceDTO invoice;
    private InvoiceCodeDTO invoiceCode;
    private ProjectSiteDTO projectSite;

    public InvoiceItemDTO() {
    }

    public InvoiceItemDTO(Integer invoiceItemID) {
        this.invoiceItemID = invoiceItemID;
    }

    public Integer getInvoiceItemID() {
        return invoiceItemID;
    }

    public void setInvoiceItemID(Integer invoiceItemID) {
        this.invoiceItemID = invoiceItemID;
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }

    public InvoiceCodeDTO getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(InvoiceCodeDTO invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public ProjectSiteDTO getProjectSite() {
        return projectSite;
    }

    public void setProjectSite(ProjectSiteDTO projectSite) {
        this.projectSite = projectSite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    
}
