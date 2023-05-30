/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author karimosama
 */
@Entity
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingid", query = "SELECT b FROM Booking b WHERE b.bookingid = :bookingid"),
    @NamedQuery(name = "Booking.findByMemberemail", query = "SELECT b FROM Booking b WHERE b.memberemail = :memberemail"),
    @NamedQuery(name = "Booking.findByTime", query = "SELECT b FROM Booking b WHERE b.time = :time"),
    @NamedQuery(name = "Booking.findByDate", query = "SELECT b FROM Booking b WHERE b.date = :date"),
    @NamedQuery(name = "Booking.findByDateAndTimeAndEmail", query = "SELECT b FROM Booking b WHERE b.date = :date and b.time = :time and b.memberemail = :memberemail"),
    @NamedQuery(name = "Booking.deleteByTimeAndDateAndMemberEmail", query = "DELETE FROM Booking b WHERE b.date = :date and b.time = :time and b.memberemail = :memberemail")
})

public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKING_ID")
    private Integer bookingid;
    @Size(max = 255)
    @Column(name = "MEMBEREMAIL")
    private String memberemail;
    @Size(max = 70)
    @Column(name = "TIME")
    private String time;
    @Size(max = 55)
    @Column(name = "DATE")
    private String date;

    public Booking() {
    }

    public Booking(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public String getMemberemail() {
        return memberemail;
    }

    public void setMemberemail(String memberemail) {
        this.memberemail = memberemail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Booking[ bookingid=" + bookingid + " ]";
    }

}
