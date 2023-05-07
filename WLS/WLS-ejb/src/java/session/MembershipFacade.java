/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.MembershipDTO;
import entity.Membership;
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
public class MembershipFacade implements MembershipFacadeRemote {

    @PersistenceContext(unitName = "WLS-ejbPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    protected EntityManager getEntityManager(){
        return em;
    }
    
    
    private void create(Membership membership){
        em.persist(membership);
    }
    
    
    private void remove(Membership membership){
        em.remove(em.merge(membership));
    }
    
    private void edit(Membership membership){
        em.merge(membership);
    }
    
    private Membership find(Object name){
        Query query = em.createNamedQuery("Memberships.findByName", Membership.class).setParameter("name", name);
        List<Membership> list = query.getResultList();
        if (list.isEmpty()){
            return null;
        }
        
        return list.get(0);
    }

    @RolesAllowed({"ED-COACHES"})
    @Override
    public Boolean add_membership(MembershipDTO membership) {
        
        Membership m = find(membership.getName());
        try{
            Membership mDAO = DTO2DAO(membership);
            if (m == null){
                create(mDAO);
                return true;
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
        return false;
    }
    
    
    
    private Membership DTO2DAO(MembershipDTO dto){
        Membership dao = new Membership();
        
        dao.setName(dto.getName());
        dao.setPrice(dto.getPrice());
        dao.setMembershipLenght(dto.getLength());
        dao.setDescritption(dto.getDescription());
        
       return dao;
    }
    
    
    
}
