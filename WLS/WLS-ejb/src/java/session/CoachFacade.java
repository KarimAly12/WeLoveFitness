/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.CoachDTO;
import entity.Coach;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    
    
    
}
