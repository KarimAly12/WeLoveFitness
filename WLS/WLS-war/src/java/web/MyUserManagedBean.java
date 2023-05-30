/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.BookingDTO;
import dto.CoachAvailaibilityDTO;
import dto.CoachDTO;
import dto.MemberDTO;
import dto.TrainingTimeDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import session.BookingFacadeRemote;
import session.CoachFacadeRemote;
import session.MyUserFacadeRemote;
import session.coachAvalFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "myUserManagedBean")
@SessionScoped
public class MyUserManagedBean implements Serializable {

    @EJB
    private BookingFacadeRemote bookingFacade;

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
    private String oldPassword;
    private String confirmPassword;
    private String newPasswod;
    private MemberDTO member;

    public String getNewPasswod() {
        return newPasswod;
    }

    public void setNewPasswod(String newPasswod) {
        this.newPasswod = newPasswod;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public MemberDTO getMember() {
        member = myuserFacade.findUserByEmail(userEmail);
        return member;
    }

    public void setMember(MemberDTO user) {
        this.member = user;
    }

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

    public void addUser() {
        //try {
        if (userID != null && userName != null && userPhoneNumber != null && userPassword != null && SEQN != null && SEAN != null) {
            MemberDTO userSearched = myuserFacade.findUserByEmail(userEmail);

            if (userSearched == null) {
                System.err.println("IN");
                MemberDTO user = new MemberDTO(Integer.parseInt(userID), userName, userPhoneNumber, userEmail, userPassword, SEQN, SEAN, null);
                if (myuserFacade != null) {
                    myuserFacade.createUser(user);
                }
            }
        }
        /*} catch (Exception e) {
            System.out.print(e);
        }*/
    }

    public String buyMembership() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        String membershipParam = externalContext.getRequestParameterMap().get("membershipName");

        //System.out.println(userEmail);
        if (myuserFacade.buyMembership(userEmail, membershipParam)) {

            return "";
        } else {
            return "";
        }

    }

    public void isValiduseremail(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        MemberDTO user = myuserFacade.findUserByEmail(userEmail);

        if (user != null) {
            FacesMessage message = new FacesMessage("The email exist. Write different email");
            userEmail = member.getMemberEmail();

            throw new ValidatorException(message);

        }
        return;
    }

    public String isLoginValid() {
        String result = "";
        MemberDTO userDTO = myuserFacade.findUserbyPasswordAndEmail(userPassword, userEmail);

        if (userDTO == null) {

            result = "/member/signup.xhtml";
        } else {
            result = "/member/mainmenu.xhtml";
            //System.out.println("validLogin");
        }

        return result;

    }

    public String openUpdatePage() {
        member = myuserFacade.findUserByEmail(userEmail);

        System.out.println("openUpdatePage " + member.getMemberEmail());

        return "/member/updateMember.xhtml";

    }

    public void isValidOldPassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        System.out.println("isValidOldPassword " + oldPassword);
        if (oldPassword != member.getMemberPassword()) {
            FacesMessage message = new FacesMessage("The email exist. Write different email");

            throw new ValidatorException(message);

        }

        return;

    }

    public void isValidNewPassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8}$";

        Pattern pattern = Pattern.compile(regex);

        System.out.println("isValidNewPassword " + newPasswod);
        Matcher matcher = pattern.matcher(newPasswod.trim());

        if (matcher.matches()) {
            FacesMessage message = new FacesMessage("The password must be 8 character, one capital letter, one small letter and 1 number.");

            throw new ValidatorException(message);

        }

        return;

    }

    public void isValidConfirmPassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if (newPasswod == confirmPassword) {
            FacesMessage message = new FacesMessage("Password is not equal");

            throw new ValidatorException(message);

        }

        return;

    }

    public String updateMember() {

        MemberDTO m = new MemberDTO(this.member.getMemberID(), userName, userPhoneNumber, userEmail, newPasswod, SEQN, SEAN, member.getMembershipName());

        if (myuserFacade.updateMember(m)) {
            return "";
        } else {
            return "";
        }

    }

    public String addBooking() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        String userEmailParam = externalContext.getRequestParameterMap().get("userEmail");
        System.out.println(userEmail);

        String bookingTimeParam = externalContext.getRequestParameterMap().get("bookingTime");
        String bookingDateParam = externalContext.getRequestParameterMap().get("bookingDate");

        System.out.println(bookingTimeParam);
        System.out.println(bookingDateParam);
        
        BookingDTO bookingDTO = new BookingDTO(userEmail, bookingTimeParam, bookingDateParam);
        
        if(bookingFacade.createBooking(bookingDTO)){
            return "";
        }else{
            System.out.println("in");
            return "";
        }

    }

   

    public MyUserManagedBean() {
    }

}
