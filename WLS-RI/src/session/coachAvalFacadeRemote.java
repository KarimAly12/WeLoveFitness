/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.CoachAvailaibilityDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author karimosama
 */
@Remote
public interface coachAvalFacadeRemote {
    
        boolean createAvailability(CoachAvailaibilityDTO availabilityDTO);

        ArrayList<CoachAvailaibilityDTO> findAllAvals();

}
