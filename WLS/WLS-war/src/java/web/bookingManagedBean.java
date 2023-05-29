/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Booking;
import dto.CoachAvailaibilityDTO;
import dto.CoachDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import session.CoachFacadeRemote;
import session.coachAvalFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "bookingManagedBean")
@SessionScoped
public class bookingManagedBean implements Serializable {

    @EJB
    private coachAvalFacadeRemote coachAvalFacade;

    @EJB
    private CoachFacadeRemote coachFacade;

    private ArrayList<Booking> bookings;

    public ArrayList<Booking> getBooking() {
       
        bookings = initBookings();

        return bookings;
    }

    public void setBooking(ArrayList<Booking> booking) {
        this.bookings = booking;
    }

    /**
     * Creates a new instance of bookingManagedBean
     */

    private ArrayList<Booking> initBookings() {
        
        ArrayList<CoachAvailaibilityDTO> avals = coachAvalFacade.findAllAvals();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        
        
        for(CoachAvailaibilityDTO cadto: avals ){
            
            CoachDTO coachDTO = coachFacade.findCoach(cadto.getCOACHID());
            
            Booking booking = new Booking(coachDTO.getName(), coachDTO.getGender(), coachDTO.getAge(), cadto.getTIME(), cadto.getDATE());
            
            bookings.add(booking);
               
        }
        
        return bookings;   
    }

    public bookingManagedBean() {
    }

}
