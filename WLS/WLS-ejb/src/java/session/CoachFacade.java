/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.CoachAvailaibilityDTO;
import dto.CoachDTO;
import entity.Coach;
import entity.Coachavailaibility;
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
public class CoachFacade implements CoachFacadeRemote {
    
    
    
    
    @PersistenceContext(unitName = "WLS-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    private void create(Coach coach) {
        em.persist(coach);
    }

    private void edit(Coach coach) {
        em.merge(coach);
    }

    private void remove(Coach coach) {
        em.remove(em.merge(coach));
    }

    private Coach find(Object id) {
        return em.find(Coach.class, id);
    }
    
    
    private void createAvailability(Coachavailaibility aval){
        em.persist(aval);  
    }
    
    private Coachavailaibility findAvailability(Object id){
        return em.find(Coachavailaibility.class, id);
    }
    
    
    
    
    
    
    
    
    
    @Override
      public ArrayList<CoachDTO> findAllAvals() {

        ArrayList<CoachDTO> coachDTOs = new ArrayList<CoachDTO>();
        Query query = em.createNamedQuery("Coach.findAll");

        try {
            List<Coach> coaches = query.getResultList();

            for (Coach c : coaches) {

                CoachDTO cadto = DAO2DTO(c);
                coachDTOs.add(cadto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return coachDTOs;
    }
    
    
    
    
  
    
    @RolesAllowed({"ED-COACHES"})
    @Override
    public boolean addCoach(CoachDTO coach) {
       
        try{
            
            Coach c = find(coach.getCoachid());
            
            if (c == null){
                
                create(DTO2DAO(coach));
            }
            
            return true;
            
        }catch(Exception ex){
            return false;
        }
        
    }
    
    
    
    private CoachDTO DAO2DTO(Coach c){
        
        return new CoachDTO(c.getCoachid(), c.getName(), c.getAge(), c.getGender(), c.getSalary());
    }
    
    
    private Coach DTO2DAO(CoachDTO c){
        Coach coach = new Coach();
        coach.setCoachid(c.getCoachid());
        coach.setName(c.getName());
        coach.setAge(c.getAge());
        coach.setGender(c.getGender());
        coach.setSalary(c.getSalary());
        
        return coach;
    }

    
    
    
   
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public CoachDTO findCoach(String coachID) {
        
        
        try {
            return DAO2DTO(find(coachID));
            
        } catch (Exception e) {
        }
        return null;
    }

    
   
    
}
