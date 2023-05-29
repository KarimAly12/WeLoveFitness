/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.CoachAvailaibilityDTO;
import dto.MembershipDTO;
import entity.Coachavailaibility;
import entity.Membership;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author karimosama
 */
@DeclareRoles({"ED-COACHES"})
@Stateless
public class coachAvalFacade implements coachAvalFacadeRemote {

    @PersistenceContext(unitName = "WLS-ejbPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    protected EntityManager getEntityManager() {
        return em;
    }

    private void create(Coachavailaibility aval) {

        em.persist(aval);

    }

    private Coachavailaibility find(Object id) {
        return em.find(Coachavailaibility.class, id);
    }
    
    
      @Override
      public ArrayList<CoachAvailaibilityDTO> findAllAvals() {

        ArrayList<CoachAvailaibilityDTO> coachAvailaibilityDTOs = new ArrayList<CoachAvailaibilityDTO>();
        Query query = em.createNamedQuery("Coachavailaibility.findAll");

        try {
            List<Coachavailaibility> avals = query.getResultList();

            for (Coachavailaibility c : avals) {

                CoachAvailaibilityDTO cadto = caDAO2DTO(c);
                coachAvailaibilityDTOs.add(cadto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return coachAvailaibilityDTOs;
    }
    
    
    
   
    @RolesAllowed({"ED-COACHES"})
    @Override
    public boolean createAvailability(CoachAvailaibilityDTO availabilityDTO) {
        System.out.println(availabilityDTO.getCOACHID());
        Coachavailaibility avali = find(availabilityDTO.getAvaliID());
        
        try {

            

            System.out.println("in");
            if (avali == null) {

                create(caDTO2DAO(availabilityDTO));

            }

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    private CoachAvailaibilityDTO caDAO2DTO(Coachavailaibility dao) {

        return new CoachAvailaibilityDTO(dao.getAvailaibilityid(), dao.getCoachid(), dao.getDate(), dao.getTime());

    }

    private Coachavailaibility caDTO2DAO(CoachAvailaibilityDTO dto) {

        Coachavailaibility dao = new Coachavailaibility();

        dao.setAvailaibilityid(dto.getAvaliID());
        dao.setCoachid(dto.getCOACHID());
        dao.setDate(dto.getDATE());
        dao.setTime(dto.getTIME());

        return dao;
    }

    
}
