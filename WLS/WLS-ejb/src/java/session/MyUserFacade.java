/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.MemberDTO;
import entity.WlsUser;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author karimosama
 */
@Stateless
public class MyUserFacade implements MyUserFacadeRemote {

    @PersistenceContext(unitName = "WLS-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    private void create(WlsUser myuser) {
        em.persist(myuser);
    }

    private void edit(WlsUser myuser) {
        em.merge(myuser);
    }

    private void remove(WlsUser myuser) {
        em.remove(em.merge(myuser));
    }

    private WlsUser find(Object id) {
        return em.find(WlsUser.class, id);
    }

    @Override
    public MemberDTO findUserByEmail(String email) {
        Query query = em.createNamedQuery("WlsUser.findByUseremail").setParameter("useremail", email);

        try {

            ArrayList<MemberDTO> userDTOList = new ArrayList<MemberDTO>();

            List<WlsUser> userList = query.getResultList();

            for (int i = 0; i < userList.size(); i++) {
                userDTOList.add(myUserDAO2DTO(userList.get(i)));
            }
            
            System.out.println("findUserByEmail " + userDTOList.get(0).getMemberEmail());
            return userDTOList.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public MemberDTO findUserbyPasswordAndEmail(String password, String userEmail) {
        Query query = em.createNamedQuery("WlsUser.findByUserUseremailAndPassword").setParameter("userpassword", password).setParameter("useremail", userEmail);

        try {
            ArrayList<MemberDTO> userDTOList = new ArrayList<MemberDTO>();

            List<WlsUser> userList = query.getResultList();

            for (int i = 0; i < userList.size(); i++) {
                userDTOList.add(myUserDAO2DTO(userList.get(i)));
            }

            if (!userDTOList.isEmpty()) {
                return userDTOList.get(0);
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.out.println("Exception catched from findUserbyPasswordAndEmail");
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean createUser(MemberDTO userDTO) {

        WlsUser user = myUserDTO2DAO(userDTO);

        create(user);

        return true;

    }

    @Override
    public MemberDTO findUser(Integer userID) {

        WlsUser user = find(userID);
        if (user == null) {
            return null;
        }
        return myUserDAO2DTO(user);
    }

    private MemberDTO myUserDAO2DTO(WlsUser user) {
        MemberDTO userDTO = new MemberDTO(
                user.getUserid(),
                user.getUsername(),
                user.getUserphonenumber(),
                user.getUseremail(),
                user.getUserpassword(),
                user.getUserseqn(),
                user.getUsersean(),
                user.getMembership()
        );

        return userDTO;

    }
    
    
    
    
    @Override
    public boolean buyMembership(String userEmail, String membershipName){
        WlsUser user = myUserDTO2DAO(findUserByEmail(userEmail));
        
        try {
            
            
            if (user != null){
                System.out.println("User is not null");
                user.setMembership(membershipName);
                System.out.println("membership " + membershipName);
                System.out.println("user Membership " + user.getMembership());
                edit(user);
                return  true;
                
            }
            
            
        } catch (Exception e) {
            return false;
        }
        
        return false;
    }
    
    
    
    
    

    private WlsUser myUserDTO2DAO(MemberDTO myUserDTO) {
        WlsUser user = new WlsUser();

        user.setUserid(myUserDTO.getMemberID());
        user.setUsername(myUserDTO.getMemberName());
        user.setUserphonenumber(myUserDTO.getMemberPhoneNumber());
        user.setUseremail(myUserDTO.getMemberEmail());
        user.setUserpassword(myUserDTO.getMemberPassword());
        user.setUserseqn(myUserDTO.getSEQN());
        user.setUsersean(myUserDTO.getSEAN());
        user.setMembership(myUserDTO.getMembershipName());

        return user;
    }

    @Override
    public boolean updateMember(MemberDTO member) {
        
       try{
           
           edit(myUserDTO2DAO(member));
           return true;
           
           
           
       }catch(Exception ex){
           
       }
        
        
        
        return false;
    }

    @Override
    public boolean deleteMember(String userEmail) {
        try{
            WlsUser user = myUserDTO2DAO(findUserByEmail(userEmail));
            
            remove(user);
            
            return true;
            
        }catch(Exception ex){
        
            return false;
        }
    }

}
