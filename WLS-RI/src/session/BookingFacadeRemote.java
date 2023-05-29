/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.BookingDTO;
import dto.TrainingTimeDTO;
import dto.CoachAvailaibilityDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author karimosama
 */
@Remote
public interface BookingFacadeRemote {

    ArrayList<BookingDTO> findAllBooking();

    boolean createBooking(BookingDTO bookingDTO);

}
