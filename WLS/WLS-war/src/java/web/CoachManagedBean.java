/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import session.CoachFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "coachManagedBean")
@Dependent
public class CoachManagedBean {

    @EJB
    private CoachFacadeRemote coachFacade;

    /**
     * Creates a new instance of CoachManagedBean
     */
    public CoachManagedBean() {
    }
    
}
