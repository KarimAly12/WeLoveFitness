/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.CoachAvailaibilityDTO;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import session.CoachFacadeRemote;
import session.coachAvalFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "avalManagedBean")
@ManagedBean
@SessionScoped
public class AvalManagedBean implements Serializable{

    @EJB
    private coachAvalFacadeRemote coachAvalFacade;

   

    /**
     * Creates a new instance of AvalManagedBean
     */
    
    
    private Integer avalID;
    private String coachID;
    private String date;
    private String time;

    public Integer getAvalID() {
        return avalID;
    }

    public void setAvalID(Integer avalID) {
        this.avalID = avalID;
    }

    public String getCoachID() {
        return coachID;
    }

    public void setCoachID(String coachID) {
        this.coachID = coachID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    public String addAval(){
        
        CoachAvailaibilityDTO ca = new CoachAvailaibilityDTO(avalID, coachID, date, time);
        
        
        if(coachAvalFacade.createAvailability(ca)){
            return "";
        }
        
        return "";
        
        
        
    }
    
    
    
    public AvalManagedBean() {
    }
    
}
