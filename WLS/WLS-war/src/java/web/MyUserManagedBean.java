/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.MyUserDTO;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import session.MyUserFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "myUserManagedBean")
@SessionScoped
public class MyUserManagedBean implements Serializable{

    @javax.ejb.EJB
    private MyUserFacadeRemote myuserFacade;
    /**
     * Creates a new instance of MyUserManagedBean
     *
     */

    private String userID;
    private String userName;
    private String userPhoneNumber;
    private String userEmail;
    private String userPassword;
    private String SEQN;
    private String SEAN;
    private String membershipName;

    public MyUserFacadeRemote getMyuserFacade() {
        return myuserFacade;
    }

    public void setMyuserFacade(MyUserFacadeRemote myuserFacade) {
        this.myuserFacade = myuserFacade;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSEQN() {
        return SEQN;
    }

    public void setSEQN(String SEQN) {
        this.SEQN = SEQN;
    }

    public String getSEAN() {
        return SEAN;
    }

    public void setSEAN(String SEAN) {
        this.SEAN = SEAN;
    }
    
    public void addUser(){
        //try {
        if (userID != null && userName != null && userPhoneNumber != null && userPassword != null && SEQN != null && SEAN != null){
            MyUserDTO userSearched = myuserFacade.findUserByEmail(userEmail);

            if (userSearched == null){
                System.err.println("IN");
                MyUserDTO user = new MyUserDTO(Integer.parseInt(userID), userName, userPhoneNumber, userEmail, userPassword, SEQN, SEAN, null);
                if (myuserFacade != null)
                  myuserFacade.createUser(user);
           }
        }
        /*} catch (Exception e) {
            System.out.print(e);
        }*/
    }
    
    
    
    public String buyMembership(){
        
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        
        String membershipParam = externalContext.getRequestParameterMap().get("membershipName");
        
        //System.out.println(userEmail);
        
        if (myuserFacade.buyMembership(userEmail, membershipParam)){
            
            return "";
        }else{
            return ""; 
        }
        
    }
    
    
    public void isValiduseremail(FacesContext context, UIComponent component, Object value) throws ValidatorException{
       
        MyUserDTO user = myuserFacade.findUserByEmail(userEmail);
        
        if(user != null){
            FacesMessage message = new FacesMessage("The email exist. Write different email");
            userEmail = "";
            
            throw new ValidatorException(message);
            
        }
        return;
    }
    
     public String isLoginValid(){
        String result = "";
        MyUserDTO userDTO = myuserFacade.findUserbyPasswordAndEmail(userPassword, userEmail);
        
        if(userDTO == null){
            
            result= "/Members/signup.xhtml";
        }else{
            result= "/Members/mainmenu.xhtml";
            //System.out.println("validLogin");
        }
        
        return result;
        
    }
   

    public MyUserManagedBean() {
    }

}
