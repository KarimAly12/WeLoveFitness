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
    private String userEmailSignUp;
    private String loginUserPassword;
    private String loginUserEmail;
    private String SEQN;
    private String SEAN;
    private String membershipName;
    private String oldPassword;
    private String confirmPassword;
    private String newPassword;
    private MemberDTO member;

    public String getLoginUserEmail() {
        return loginUserEmail;
    }

    public void setLoginUserEmail(String loginUserEmail) {
        this.loginUserEmail = loginUserEmail;
    }

    public String getLoginUserPassword() {
        return loginUserPassword;
    }

    public void setLoginUserPassword(String loginUserPassword) {
        this.loginUserPassword = loginUserPassword;
    }

    public String getUserEmailSignUp() {
        return userEmailSignUp;
    }

    public void setUserEmailSignUp(String userEmailSignUp) {
        this.userEmailSignUp = userEmailSignUp;
    }

    public String getNewPasswod() {
        return newPassword;
    }

    public void setNewPasswod(String newPasswod) {
        this.newPassword = newPasswod;
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
        //userEmail = "";
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }
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
        if (userID != null && userName != null && userPhoneNumber != null && SEQN != null && SEAN != null) {
            MemberDTO userSearched = myuserFacade.findUser(Integer.parseInt(userID));
            System.err.println("IN");

            if (userSearched == null) {
                MemberDTO user = new MemberDTO(Integer.parseInt(userID), userName, userPhoneNumber, userEmail, newPassword, SEQN, SEAN, null);
                if (myuserFacade != null) {
                    myuserFacade.createUser(user);
                    newPassword = "";
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

        String data = value.toString();
        MemberDTO user = myuserFacade.findUserByEmail(data);

        if (user != null) {
            
            FacesMessage message = new FacesMessage("The email exist. Write different email");

            
            if (member == null){
                 throw new ValidatorException(message);
            }
            if(!member.getMemberEmail().equalsIgnoreCase(user.getMemberEmail())){
                throw new ValidatorException(message);
            }
            userEmail = data;

            

        }
        return;
    }

    public String openUpdatePage() {
        member = myuserFacade.findUserByEmail(loginUserEmail);

        System.out.println("openUpdatePage " + member.getMemberPassword());
        
        userName = member.getMemberName();
        userPhoneNumber = member.getMemberPhoneNumber();
        SEAN = member.getSEAN();
        SEQN = member.getSEQN();
        

        return "/member/updateMember.xhtml";

    }

    public void isValidOldPassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        System.out.println("isValidOldPassword " + member.getMemberPassword());
        if (!value.toString().equalsIgnoreCase(member.getMemberPassword())) {
            FacesMessage message = new FacesMessage("Your old password is incorrect");

            throw new ValidatorException(message);

        }

        return;

    }

    public void isValidNewPassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[+*-].*).+$";

        Pattern pattern = Pattern.compile(regex);
        String data = value.toString();
        newPassword = data;

        System.out.println("isValidNewPassword " + newPassword);
        Matcher matcher = pattern.matcher(newPassword);

        if (data.length() != 6 || !data.matches(regex)) {
            FacesMessage message = new FacesMessage("Password should contain 6 characters, 1 capital letter, 1 small letter, 1 digit and 1 (+ - *)");

            throw new ValidatorException(message);

        }

        return;

    }

    public void isValidConfirmPassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if (newPassword == confirmPassword) {
            FacesMessage message = new FacesMessage("Password is not equal");

            throw new ValidatorException(message);

        }

        return;

    }

    public String updateMember() {
        System.out.println(member.getMemberEmail());
        MemberDTO m = new MemberDTO(member.getMemberID(), userName, userPhoneNumber, userEmail, confirmPassword, SEQN, SEAN, member.getMembershipName());

        if (myuserFacade.updateMember(m)) {
            
            newPassword = "";
            oldPassword ="";
            confirmPassword ="";
            return "/member/mainmenu.xhtml";
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

        if (bookingFacade.createBooking(bookingDTO)) {
            return "";
        } else {
            System.out.println("in");
            return "";
        }

    }
    
    
     public String isLoginValid() {
        String result = "";
        MemberDTO userDTO = myuserFacade.findUserbyPasswordAndEmail(loginUserPassword, loginUserEmail);

        if (userDTO == null) {

            result = "/member/signUp.xhtml";
        } else {
            result = "/member/mainmenu.xhtml";
            userEmail = loginUserEmail;
            //System.out.println("validLogin");
        }

        return result;

    }

    public MyUserManagedBean() {
    }

}
