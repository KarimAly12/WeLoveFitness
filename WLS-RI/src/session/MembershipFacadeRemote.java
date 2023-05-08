/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.MembershipDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author karimosama
 */
@Remote
public interface MembershipFacadeRemote {

    Boolean add_membership(MembershipDTO membership);

    ArrayList<MembershipDTO> getMembershipsAll();

    Boolean deleteMembership(String membershipname);
    
}
