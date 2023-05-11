/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author karimosama
 */
public class MyUserDTO {
    private final Integer userID;
    private final String userName;
    private final String userPhoneNumber;
    private final String userEmail;
    private final String userPassword;
    private final String SEQN;
    private final String SEAN;
    private final String membershipName;

    public String getMembershipName() {
        return membershipName;
    }


    public MyUserDTO(Integer userID, String userName, String userPhoneNumber, String userEmail, String userPassword, String SEQN, String SEAN,String membershipName) {
        this.userID = userID;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.SEQN = SEQN;
        this.SEAN = SEAN;
        this.membershipName = membershipName;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getSEQN() {
        return SEQN;
    }

    public String getSEAN() {
        return SEAN;
    }
    
    
    
}
