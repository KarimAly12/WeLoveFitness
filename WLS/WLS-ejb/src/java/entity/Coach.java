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
@Table(name = "CAOCHES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coach.findAll", query = "SELECT c FROM Coach c"),
    @NamedQuery(name = "Coach.findByCoachid", query = "SELECT c FROM Coach c WHERE c.coachid = :coachid"),
    @NamedQuery(name = "Coach.findByName", query = "SELECT c FROM Coach c WHERE c.name = :name"),
    @NamedQuery(name = "Coach.findByAge", query = "SELECT c FROM Coach c WHERE c.age = :age"),
    @NamedQuery(name = "Coach.findByGender", query = "SELECT c FROM Coach c WHERE c.gender = :gender"),
    @NamedQuery(name = "Coach.findBySalary", query = "SELECT c FROM Coach c WHERE c.salary = :salary")})
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "COACHID")
    private String coachid;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Size(max = 50)
    @Column(name = "GENDER")
    private String gender;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private Double salary;

    public Coach() {
    }

    public Coach(String coachid) {
        this.coachid = coachid;
    }

    public String getCoachid() {
        return coachid;
    }

    public void setCoachid(String coachid) {
        this.coachid = coachid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coachid != null ? coachid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coach)) {
            return false;
        }
        Coach other = (Coach) object;
        if ((this.coachid == null && other.coachid != null) || (this.coachid != null && !this.coachid.equals(other.coachid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Caoches[ coachid=" + coachid + " ]";
    }
    
}
