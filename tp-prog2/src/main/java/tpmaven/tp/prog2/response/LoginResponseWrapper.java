/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Matias
 */
public class LoginResponseWrapper {

    @JsonProperty
    String sessionId ;


    public LoginResponseWrapper() {

    }

    public LoginResponseWrapper(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
