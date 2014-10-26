/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.monitor.gate;

import com.boha.monitor.dto.transfer.RequestDTO;
import com.boha.monitor.dto.transfer.ResponseDTO;
import com.boha.monitor.util.DataUtil;
import com.boha.monitor.util.GZipUtility;
import com.boha.monitor.util.ListUtil;
import com.boha.monitor.util.PlatformUtil;
import com.boha.monitor.util.TrafficCop;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author aubreyM
 */
@ServerEndpoint("/wscompany")
@Stateful
public class CompanyWebSocket {

    @EJB
    DataUtil dataUtil;
    @EJB
    ListUtil listUtil;
    @EJB
    PlatformUtil platformUtil;
    @EJB
    TrafficCop trafficCop;

    static final String SOURCE = "CompanyWebSocket";
    //TODO - clean up expired sessions!!!!
    public static final Set<Session> peers
            = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public ByteBuffer onMessage(String message) {
        log.log(Level.WARNING, "###### onMessage: {0}", message);
        ResponseDTO resp = new ResponseDTO();
        ByteBuffer bb = null;
        try {
            RequestDTO dto = gson.fromJson(message, RequestDTO.class);
            resp = trafficCop.processRequest(dto, dataUtil, listUtil);
            bb = GZipUtility.getZippedResponse(resp);
        } catch (IOException ex) {
            Logger.getLogger(ProjectWebSocket.class.getName()).log(Level.SEVERE, null, ex);
            resp.setStatusCode(111);
            resp.setMessage("Problem processing request on server");
            dataUtil.addErrorStore(19, dataUtil.getErrorString(ex), SOURCE);
            try {
                bb = GZipUtility.getZippedResponse(resp);
            } catch (IOException ex1) {
                Logger.getLogger(ProjectWebSocket.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return bb;
    }

    @OnOpen
    public void onOpen(Session session) {
        peers.add(session);
        try {
            ResponseDTO r = new ResponseDTO();
            r.setSessionID(session.getId());
            r.setStatusCode(0);
            session.getBasicRemote().sendText(gson.toJson(r));
            log.log(Level.WARNING, "########## onOpen...sent session id: {0}", session.getId());
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Failed to send websocket sessionID", ex);
        }
    }

    @OnClose
    public void onClose(Session session
    ) {
        log.log(Level.WARNING, "onClose - remove session: {0}", session.getId());
        for (Session mSession : peers) {
            if (session.getId().equalsIgnoreCase(mSession.getId())) {
                peers.remove(mSession);
                break;
            }
        }
    }

    @OnError
    public void onError(Throwable t) {
        log.log(Level.SEVERE, "#############################@OnError, websocket failed", t);
        ResponseDTO r = new ResponseDTO();
        r.setStatusCode(9);
        //session.getBasicRemote().sendText(gson.toJson(r));
    }

    Gson gson = new Gson();
    static final Logger log = Logger.getLogger(CompanyWebSocket.class.getSimpleName());
}
