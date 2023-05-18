/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.CoachDTO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import session.CoachFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "coachManagedBean")
@SessionScoped
public class CoachManagedBean implements Serializable{

    @EJB
    private CoachFacadeRemote coachFacade;

    /**
     * Creates a new instance of CoachManagedBean
     */
    
    private String coachID;
    private String coachName;
    private int age;
    private String coachGender;
    private double salary;

    public CoachFacadeRemote getCoachFacade() {
        return coachFacade;
    }

    public void setCoachFacade(CoachFacadeRemote coachFacade) {
        this.coachFacade = coachFacade;
    }

    public String getCoachID() {
        return coachID;
    }

    public void setCoachID(String coachID) {
        this.coachID = coachID;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCoachGender() {
        return coachGender;
    }

    public void setCoachGender(String coachGender) {
        this.coachGender = coachGender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
    public CoachManagedBean() {
    }
    
    
    public String addCoach(){
        
        CoachDTO coachDTO = new CoachDTO(coachID, coachName, age, coachGender, salary);
        
        
        if (coachID.length() == 6){
            if(coachFacade.addCoach(coachDTO)){
            System.out.println(coachID);
            
            return "";
              
        }
        }
        
        
        
        return "";
        
    }
    
    
    
    public void isValidCoachID(FacesContext context, UIComponent component, Object value){
        
        
        
        
    }
    
}
