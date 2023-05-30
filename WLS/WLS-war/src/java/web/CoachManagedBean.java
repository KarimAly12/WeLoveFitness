/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.BookingDTO;
import dto.CoachDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import session.BookingFacadeRemote;
import session.CoachFacadeRemote;

/**
 *
 * @author karimosama
 */
@Named(value = "coachManagedBean")
@SessionScoped
public class CoachManagedBean implements Serializable {

    @EJB
    private BookingFacadeRemote bookingFacade;

    @EJB
    private CoachFacadeRemote coachFacade;

    /**
     * Creates a new instance of CoachManagedBean
     */
    private String coachID;
    private String coachName;
    private int age;
    private String coachGender;
    private double salary;
    private ArrayList<BookingDTO> customerBookings;

    public ArrayList<BookingDTO> getCustomerBookings() {
        customerBookings = bookingFacade.findAllBooking();
        return customerBookings;
    }

    public void setCustomerBookings(ArrayList<BookingDTO> customerBookings) {

        this.customerBookings = customerBookings;
    }

    public String getCoachID() {
        return coachID;
    }

    public void setCoachID(String coachID) {
        this.coachID = coachID;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCoachGender() {
        return coachGender;
    }

    public void setCoachGender(String coachGender) {
        this.coachGender = coachGender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public CoachManagedBean() {
    }

    public String addCoach() {

        CoachDTO coachDTO = new CoachDTO(coachID, coachName, age, coachGender, salary);

        if (coachID.length() == 6) {
            if (coachFacade.addCoach(coachDTO)) {
                System.out.println(coachID);

                return "";

            }
        }

        return "";

    }

    public String deleteBooking() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        String userEmailParam = externalContext.getRequestParameterMap().get("bookingMemberEmail");
        String bookingTimeParam = externalContext.getRequestParameterMap().get("custbookingTime");
        String bookingDateParam = externalContext.getRequestParameterMap().get("custbookingDate");
        
        
        BookingDTO bookingDTO = new BookingDTO(userEmailParam, bookingTimeParam, bookingDateParam);
        
        if(bookingFacade.deleteBooking(bookingDTO)){
            customerBookings = getCustomerBookings();
            return "";
            
        }else{
            return "";
        }

    }

    public void isValidCoachID(FacesContext context, UIComponent component, Object value) {

    }

}
