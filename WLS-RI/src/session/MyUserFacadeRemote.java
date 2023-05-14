/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.MemberDTO;
import javax.ejb.Remote;

/**
 *
 * @author karimosama
 */
@Remote
public interface MyUserFacadeRemote {
    
    
    boolean createUser(MemberDTO userDTO);
    
    MemberDTO findUser(Integer userID);
    
    MemberDTO findUserbyPasswordAndEmail(String password, String userEmail);
    MemberDTO findUserByEmail(String email);
    boolean buyMembership(String userEmail, String membershipName);

    boolean updateMember(MemberDTO member);
}
