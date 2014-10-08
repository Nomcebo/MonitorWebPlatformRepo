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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "invoice")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceID", query = "SELECT i FROM Invoice i WHERE i.invoiceID = :invoiceID"),
    @NamedQuery(name = "Invoice.findByInvoiceDate", query = "SELECT i FROM Invoice i WHERE i.invoiceDate = :invoiceDate"),
    @NamedQuery(name = "Invoice.findByInvoiceDueDate", query = "SELECT i FROM Invoice i WHERE i.invoiceDueDate = :invoiceDueDate"),
    @NamedQuery(name = "Invoice.findByDateRegistered", query = "SELECT i FROM Invoice i WHERE i.dateRegistered = :dateRegistered")})
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoiceID")
    private Integer invoiceID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoiceDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDate;
    @Column(name = "invoiceDueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDueDate;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @JoinColumn(name = "companyClientID", referencedColumnName = "companyClientID")
    @ManyToOne(optional = false)
    private CompanyClient companyClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceItem> invoiceItemList;
    @OneToMany(mappedBy = "invoice")
    private List<SiteCheckPoint> siteCheckPointList;

    public Invoice() {
    }

    public Invoice(Integer invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Invoice(Integer invoiceID, Date invoiceDate) {
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
    }

    public Integer getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Integer invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public void setInvoiceDueDate(Date invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public CompanyClient getCompanyClient() {
        return companyClient;
    }

    public void setCompanyClient(CompanyClient companyClient) {
        this.companyClient = companyClient;
    }

 

    public List<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    public void setInvoiceItemList(List<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
    }

    public List<SiteCheckPoint> getSiteCheckPointList() {
        return siteCheckPointList;
    }

    public void setSiteCheckPointList(List<SiteCheckPoint> siteCheckPointList) {
        this.siteCheckPointList = siteCheckPointList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceID != null ? invoiceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceID == null && other.invoiceID != null) || (this.invoiceID != null && !this.invoiceID.equals(other.invoiceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.monitor.data.Invoice[ invoiceID=" + invoiceID + " ]";
    }
    
}
