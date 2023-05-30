/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.TrainingTimeDTO;
import dto.CoachAvailaibilityDTO;
import dto.CoachDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
    
    

    private ArrayList<TrainingTimeDTO> bookings;

    public ArrayList<TrainingTimeDTO> getBookings() {

        bookings = initBookings();

        return bookings;
    }

    public void setBookings(ArrayList<TrainingTimeDTO> booking) {
        this.bookings = booking;
    }

    /**
     * Creates a new instance of bookingManagedBean
     */
    public void addBooking() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        String userEmailParam = externalContext.getRequestParameterMap().get("userEmail");
        System.out.println(userEmailParam);
        
        String bookingTimeParam = externalContext.getRequestParameterMap().get("bookingTime");
        String bookingDateParam = externalContext.getRequestParameterMap().get("bookingDate");
        
        System.out.println(bookingTimeParam);
        System.out.println(bookingDateParam);
        
        
        

    }

    private ArrayList<TrainingTimeDTO> initBookings() {

        ArrayList<CoachAvailaibilityDTO> avals = coachAvalFacade.findAllAvals();
        ArrayList<TrainingTimeDTO> bookings = new ArrayList<TrainingTimeDTO>();

        for (CoachAvailaibilityDTO cadto : avals) {

            CoachDTO coachDTO = coachFacade.findCoach(cadto.getCOACHID());

            TrainingTimeDTO booking = new TrainingTimeDTO(coachDTO.getName(), coachDTO.getGender(), coachDTO.getAge(), cadto.getTIME(), cadto.getDATE());

            bookings.add(booking);

        }

        return bookings;
    }

    public bookingManagedBean() {
    }

}
