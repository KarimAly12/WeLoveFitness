/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.MemberDTO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import session.MyUserFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class EmployeeLoginManagedBean implements Serializable{

    @EJB
    private MyUserFacadeRemote myUserFacade;

    /**
     * Creates a new instance of LoginManagedBean
     */
    
    private String userEmail;
    private String password;

   
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public EmployeeLoginManagedBean() {
    }
    
    public String isLoginValid() {
        String result = "";
        MemberDTO userDTO = myUserFacade.findUserbyPasswordAndEmail(password, userEmail);

        if (userDTO == null) {

            result = "/member/signUp.xhtml";
        } else {
            result = "/member/mainmenu.xhtml";
            //System.out.println("validLogin");
        }

        return result;

    }
    
}
