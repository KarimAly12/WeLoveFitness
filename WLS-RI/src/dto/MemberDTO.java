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
public class MemberDTO {
    private final Integer memberID;
    private final String memberName;
    private final String memberPhoneNumber;
    private final String memberEmail;
    private final String memberPassword;
    private final String SEQN;
    private final String SEAN;
    private final String membershipName;

    public Integer getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public String getSEQN() {
        return SEQN;
    }

    public String getSEAN() {
        return SEAN;
    }

    public String getMembershipName() {
        return membershipName;
    }

    
    public MemberDTO(Integer userID, String userName, String userPhoneNumber, String userEmail, String userPassword, String SEQN, String SEAN,String membershipName) {
        this.memberID = userID;
        this.memberName = userName;
        this.memberPhoneNumber = userPhoneNumber;
        this.memberEmail = userEmail;
        this.memberPassword = userPassword;
        this.SEQN = SEQN;
        this.SEAN = SEAN;
        this.membershipName = membershipName;
    }

   
    
}
