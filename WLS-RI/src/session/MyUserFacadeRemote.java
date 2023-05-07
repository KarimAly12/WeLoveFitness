/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.MyUserDTO;
import javax.ejb.Remote;

/**
 *
 * @author karimosama
 */
@Remote
public interface MyUserFacadeRemote {
    
    
    boolean createUser(MyUserDTO userDTO);
    
    MyUserDTO findUser(Integer userID);
    
    MyUserDTO findUserbyPasswordAndEmail(String password, String userEmail);
    MyUserDTO findUserByEmail(String email);
}
