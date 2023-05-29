/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.CoachDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author karimosama
 */
@Remote
public interface CoachFacadeRemote {

    boolean addCoach(CoachDTO coach);

    ArrayList<CoachDTO> findAllAvals();

    CoachDTO findCoach(String coachID);

}
