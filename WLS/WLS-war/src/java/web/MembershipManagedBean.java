/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.MembershipDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import session.MembershipFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "membershipManagedBean")
@SessionScoped
@ManagedBean
public class MembershipManagedBean implements Serializable{

    @EJB
    private MembershipFacadeRemote membershipFacade;

    private String name;
    private Double price;
    private Integer length;
    private String description;
    private ArrayList<MembershipDTO> memberships;

    public ArrayList<MembershipDTO> getMemberships() {
        memberships = membershipFacade.getMembershipsAll();
        return memberships;
    }

    public MembershipFacadeRemote getMembershipFacade() {
        return membershipFacade;
    }

    public void setMembershipFacade(MembershipFacadeRemote membershipFacade) {
        this.membershipFacade = membershipFacade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }
    
    /**
     * Creates a new instance of MembershipManagedBean
     */
    public MembershipManagedBean() {
//      
//            if (membershipFacade.getMembershipsAll() == null){
//                System.err.println("getMembershipAll is null");
//            }else{
//                 System.err.println("getMembershipAll is not null");
//                 memberships = membershipFacade.getMembershipsAll();
//            }
            
       
    }
    
    
    
    
    public void deleteMembership(){
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        String name = ec.getRequestParameterMap().get("nameID");

        System.out.println("name");
       membershipFacade.deleteMembership(name);
       memberships = membershipFacade.getMembershipsAll();
    }
    
    
    public String addMembership(){
        
        MembershipDTO membership = new MembershipDTO(name, price, length, description);
        System.out.println(name);
        
        
        Boolean result = membershipFacade.add_membership(membership);
        
        if (result == true){
            return "membershipAdded";
        }else{
            return "membershipNotAdded";
        }
        
        
    }
    
}
