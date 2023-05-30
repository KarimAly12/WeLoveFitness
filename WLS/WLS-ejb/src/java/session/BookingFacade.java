/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dto.BookingDTO;
import dto.TrainingTimeDTO;
import entity.Booking;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author karimosama
 */
@Stateless
public class BookingFacade implements BookingFacadeRemote {

    @PersistenceContext(unitName = "WLS-ejbPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    protected EntityManager getEntityManager() {
        return em;
    }

    private void create(Booking booking) {
        em.persist(booking);
    }

    private void edit(Booking booking) {
        em.merge(booking);
    }

    private void remove(Booking booking) {
        em.remove(em.merge(booking));
    }

    private Booking find(Object id) {
        return em.find(Booking.class, id);
    }

    @Override
    public ArrayList<BookingDTO> findAllBooking() {

        Query query = em.createNamedQuery("Booking.findAll");
        List<Booking> bookings = query.getResultList();

        try {

            ArrayList<BookingDTO> bookingsList = new ArrayList<BookingDTO>();
            for (Booking b : bookings) {
                bookingsList.add(DAO2DTO(b));
            }

            return bookingsList;

        } catch (Exception ex) {

        }
        return null;
    }

    private BookingDTO DAO2DTO(Booking booking) {
        return new BookingDTO(booking.getMemberemail(), booking.getTime(), booking.getDate());
    }

    private Booking DTO2DAO(BookingDTO dto) {
        Booking booking = new Booking();

        booking.setMemberemail(dto.getMemberEmail());
        booking.setTime(dto.getTime());
        booking.setDate(dto.getDate());

        return booking;
    }

    @Override
    public boolean createBooking(BookingDTO bookingDTO) {
        Query query = em.createNamedQuery("Booking.findByDateAndTimeAndEmail").setParameter("time", bookingDTO.getTime()).setParameter("date", bookingDTO.getDate()).setParameter("memberemail", bookingDTO.getMemberEmail());
        List<Booking> bookings = query.getResultList();
        try {

            if (bookings.size() == 1) {
                return true;
            }

            System.out.println("innn");
            create(DTO2DAO(bookingDTO));
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBooking(BookingDTO bookingDTO) {
        try {
            
            Query query = em.createNamedQuery("Booking.deleteByTimeAndDateAndMemberEmail").setParameter("date", bookingDTO.getDate()).setParameter("time", bookingDTO.getTime()).setParameter("memberemail", bookingDTO.getMemberEmail());
            
            query.executeUpdate();
            
            return true;
        } catch (Exception ex) {
            
            System.out.println("in");
            ex.printStackTrace();;
            return false;
        }
    }

}
