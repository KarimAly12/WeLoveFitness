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
@Table(name = "COACHAVAILAIBILITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coachavailaibility.findAll", query = "SELECT c FROM Coachavailaibility c"),
    @NamedQuery(name = "Coachavailaibility.findByAvailaibilityid", query = "SELECT c FROM Coachavailaibility c WHERE c.availaibilityid = :availaibilityid"),
    @NamedQuery(name = "Coachavailaibility.findByCoachid", query = "SELECT c FROM Coachavailaibility c WHERE c.coachid = :coachid"),
    @NamedQuery(name = "Coachavailaibility.findByDate", query = "SELECT c FROM Coachavailaibility c WHERE c.date = :date"),
    @NamedQuery(name = "Coachavailaibility.findByTime", query = "SELECT c FROM Coachavailaibility c WHERE c.time = :time")})
public class Coachavailaibility implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVAILAIBILITYID")
    private Integer availaibilityid;
    @Size(max = 255)
    @Column(name = "COACHID")
    private String coachid;
    @Size(max = 255)
    @Column(name = "DATE")
    private String date;
    @Size(max = 255)
    @Column(name = "TIME")
    private String time;

    public Coachavailaibility() {
    }

    public Coachavailaibility(Integer availaibilityid) {
        this.availaibilityid = availaibilityid;
    }

    public Integer getAvailaibilityid() {
        return availaibilityid;
    }

    public void setAvailaibilityid(Integer availaibilityid) {
        this.availaibilityid = availaibilityid;
    }

    public String getCoachid() {
        return coachid;
    }

    public void setCoachid(String coachid) {
        this.coachid = coachid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (availaibilityid != null ? availaibilityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coachavailaibility)) {
            return false;
        }
        Coachavailaibility other = (Coachavailaibility) object;
        if ((this.availaibilityid == null && other.availaibilityid != null) || (this.availaibilityid != null && !this.availaibilityid.equals(other.availaibilityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Coachavailaibility[ availaibilityid=" + availaibilityid + " ]";
    }
    
}
