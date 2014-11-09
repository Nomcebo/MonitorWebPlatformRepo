/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.monitor.util;

import com.boha.monitor.data.ErrorStore;
import com.boha.monitor.dto.transfer.RequestDTO;
import com.boha.monitor.dto.transfer.ResponseDTO;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aubreyM
 */
@Stateless
public class TrafficCop {

    public ResponseDTO processRequest(RequestDTO req,
            DataUtil dataUtil, ListUtil listUtil) {
        ResponseDTO resp = new ResponseDTO();
        try {
            switch (req.getRequestType()) {
                //claim * invoice
                case RequestDTO.ADD_BANK:
                    resp = dataUtil.addBank(req.getBank());
                    break;
                case RequestDTO.ADD_BANK_DETAILS:
                    resp = dataUtil.addBankDetails(req.getBankDetail());
                    break;
                case RequestDTO.ADD_CONTRACTOR_CLAIM:
                    resp = dataUtil.addContractorClaim(req.getContractorClaim());
                    break;
                case RequestDTO.ADD_CONTRACTOR_CLAIM_SITE:
                    resp = dataUtil.addContractorClaimSite(req.getContractorClaimSite());
                    break;
                case RequestDTO.ADD_INVOICE:
                    resp = dataUtil.addInvoice(req.getInvoice());
                    break;
                case RequestDTO.ADD_INVOICE_ITEM:
                    resp = dataUtil.addInvoiceItem(req.getInvoiceItem());
                    break;
                case RequestDTO.REMOVE_CONTRACTOR_CLAIM:
                    break;
                case RequestDTO.REMOVE_CONTRACTOR_CLAIM_SITE:
                    break;
                case RequestDTO.REMOVE_INVOICE:
                    break;
                case RequestDTO.REMOVE_INVOICE_ITEM:
                    break;
                //updates
                case RequestDTO.UPDATE_PROJECT_SITE:
                    dataUtil.updateProjectSite(req.getProjectSite());
                    break;
                case RequestDTO.UPDATE_PROJECT:
                    dataUtil.updateProject(req.getProject());
                    break;
                case RequestDTO.UPDATE_COMPANY_TASK:
                    dataUtil.updateTask(req.getTask());
                    break;
                case RequestDTO.UPDATE_COMPANY_TASK_STATUS:
                    dataUtil.updateTaskStatus(req.getTaskStatus());
                    break;
                //add lookups
                case RequestDTO.ADD_CITY:
                    resp = dataUtil.addCity(req.getCity());
                    break;
                case RequestDTO.ADD_COMPANY_CHECKPOINT:
                    resp = dataUtil.addCompanyCheckPoint(req.getCheckPoint());
                    break;
                case RequestDTO.ADD_COMPANY_PROJECT_STATUS_TYPE:
                    resp = dataUtil.addCompanyProjectStatus(req.getProjectStatusType());
                    break;
                case RequestDTO.ADD_COMPANY_TASK:
                    resp = dataUtil.addCompanyTask(req.getTask());
                    break;
                case RequestDTO.ADD_COMPANY_TASK_STATUS:
                    resp = dataUtil.addCompanyTaskStatus(req.getTaskStatus());
                    break;
                case RequestDTO.ADD_TOWNSHIP:
                    resp = dataUtil.addTownship(req.getTownship());
                    break;

                //register entities    
                case RequestDTO.REGISTER_COMPANY:
                    resp = dataUtil.registerCompany(req.getCompany(), 
                            req.getCompanyStaff(), listUtil);
                    break;
                case RequestDTO.REGISTER_COMPANY_STAFF:
                    resp = dataUtil.registerCompanyStaff(req.getCompanyStaff());
                    break;
                case RequestDTO.REGISTER_CLIENT:
                    resp = dataUtil.registerClient(req.getClient());
                    break;
                case RequestDTO.REGISTER_BENEFICIARY:
                    resp = dataUtil.registerBeneficiary(req.getBeneficiary());
                    break;
                case RequestDTO.REGISTER_PROJECT:
                    resp = dataUtil.registerProject(req.getProject());
                    break;
                case RequestDTO.REGISTER_PROJECT_SITE:
                    resp = dataUtil.registerProjectSite(req.getProjectSite());
                    break;

                //
                case RequestDTO.ADD_DEVICE:
                    dataUtil.addDevice(req.getGcmDevice());
                    break;
                case RequestDTO.ADD_PROJECT_DIARY_RECORD:
                    resp = dataUtil.addProjectDiaryRecord(req.getProjectDiaryRecord());
                    break;
                case RequestDTO.ADD_PROJECT_SITE_TASK:
                    resp = dataUtil.addProjectSiteTask(req.getProjectSiteTask(), listUtil);
                    break;
                case RequestDTO.ADD_PROJECT_SITE_TASK_STATUS:
                    resp = dataUtil.addProjectSiteTaskStatus(req.getProjectSiteTaskStatus());
                    break;
                case RequestDTO.ADD_PROJECT_STATUS_TYPE:
                    break;
                //lists
                case RequestDTO.GET_PROJECT_DATA:
                    resp = listUtil.getProjectData(req.getProjectID());
                    break;
                case RequestDTO.GET_COMPANY_STAFF:
                    resp = listUtil.getCompanyStaffList(req.getCompanyID());
                    break;
                case RequestDTO.GET_COMPANY_DATA:
                    resp = listUtil.getCompanyData(req.getCompanyID(),
                            req.getCountryID());
                    break;
                case RequestDTO.GET_TASK_STATUS_LIST:
                    resp = listUtil.getTaskStatusList(req.getCompanyID());
                    break;
                //photos
                case RequestDTO.GET_PROJECT_IMAGES:
                    resp = listUtil.getPhotosByProject(req.getProjectID());
                    break;
                case RequestDTO.GET_SITE_IMAGES:
                    resp = listUtil.getPhotosByProjectSite(req.getProjectSiteID());
                    break;
                case RequestDTO.GET_TASK_IMAGES:
                    resp = listUtil.getPhotosByTask(req.getProjectSiteTaskID());
                    break;
                case RequestDTO.GET_ALL_PROJECT_IMAGES:
                    resp = listUtil.getAllPhotosByProject(req.getProjectID());
                    break;

                case RequestDTO.LOGIN:
                    resp = dataUtil.login(req.getGcmDevice(),
                            req.getEmail(), req.getPin(),
                            listUtil);
                    break;
            }
        } catch (DataException e) {
            resp.setStatusCode(101);
            resp.setMessage("Data service failed to process your request");
            logger.log(Level.SEVERE, "Database related failure", e);
            addErrorStore(19, e.getDescription(), "TrafficCop");
        } catch (Exception e) {
            resp.setStatusCode(102);
            resp.setMessage("Server process failed to process your request");
            logger.log(Level.SEVERE, "Generic server related failure", e);
            addErrorStore(19, "Server Error \n" + dataUtil.getErrorString(e), "TrafficCop");
        }
        if (resp.getStatusCode() == null) {
            resp.setStatusCode(0);
        }
        return resp;
    }

    public void addErrorStore(int statusCode, String message, String origin) {
        logger.log(Level.OFF, "------ adding errorStore, message: {0} origin: {1}", new Object[]{message, origin});
        try {
            ErrorStore t = new ErrorStore();
            t.setDateOccured(new Date());
            t.setMessage(message);
            t.setStatusCode(statusCode);
            t.setOrigin(origin);
            em.persist(t);
            logger.log(Level.INFO, "####### ErrorStore row added, origin {0} \nmessage: {1}",
                    new Object[]{origin, message});
        } catch (Exception e) {
            logger.log(Level.SEVERE, "####### Failed to add errorStore from " + origin + "\n" + message, e);
        }
    }
    @PersistenceContext
    EntityManager em;
    static final Logger logger = Logger.getLogger(TrafficCop.class.getSimpleName());
}
