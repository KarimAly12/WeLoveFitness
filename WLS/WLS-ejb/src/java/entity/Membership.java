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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author karimosama
 */
@Entity
@Table(name = "MEMBERSHIPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memberships.findAll", query = "SELECT m FROM Memberships m"),
    @NamedQuery(name = "Memberships.findByName", query = "SELECT m FROM Memberships m WHERE m.name = :name"),
    @NamedQuery(name = "Memberships.findByPrice", query = "SELECT m FROM Memberships m WHERE m.price = :price"),
    @NamedQuery(name = "Memberships.findByMembershipLenght", query = "SELECT m FROM Memberships m WHERE m.membershipLenght = :membershipLenght"),
    @NamedQuery(name = "Memberships.findByDescritption", query = "SELECT m FROM Memberships m WHERE m.descritption = :descritption"),
    @NamedQuery(name = "Memberships.findByMembershipKey", query = "SELECT m FROM Memberships m WHERE m.membershipKey = :membershipKey")})
public class Membership implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 55)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "MEMBERSHIP_LENGHT")
    private Integer membershipLenght;
    @Size(max = 500)
    @Column(name = "DESCRITPTION")
    private String descritption;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEMBERSHIP_KEY")
    private Integer membershipKey;

    public Membership() {
    }

    public Membership(Integer membershipKey) {
        this.membershipKey = membershipKey;
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

    public Integer getMembershipLenght() {
        return membershipLenght;
    }

    public void setMembershipLenght(Integer membershipLenght) {
        this.membershipLenght = membershipLenght;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public Integer getMembershipKey() {
        return membershipKey;
    }

    public void setMembershipKey(Integer membershipKey) {
        this.membershipKey = membershipKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membershipKey != null ? membershipKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membership)) {
            return false;
        }
        Membership other = (Membership) object;
        if ((this.membershipKey == null && other.membershipKey != null) || (this.membershipKey != null && !this.membershipKey.equals(other.membershipKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Memberships[ membershipKey=" + membershipKey + " ]";
    }
    
}
