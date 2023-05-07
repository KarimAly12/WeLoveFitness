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
import javax.persistence.Lob;
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
@Table(name = "WLS_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WlsUser.findAll", query = "SELECT w FROM WlsUser w"),
    @NamedQuery(name = "WlsUser.findByUserid", query = "SELECT w FROM WlsUser w WHERE w.userid = :userid"),
    @NamedQuery(name = "WlsUser.findByUserphonenumber", query = "SELECT w FROM WlsUser w WHERE w.userphonenumber = :userphonenumber"),
    @NamedQuery(name = "WlsUser.findByuseremail", query = "SELECT w FROM WlsUser w WHERE w.useremail = :useremail"),
    @NamedQuery(name = "WlsUser.findByUserpassword", query = "SELECT w FROM WlsUser w WHERE w.userpassword = :userpassword"),
    @NamedQuery(name = "WlsUser.findByUserUseremailAndPassword", query = "SELECT w FROM WlsUser w WHERE w.userpassword = :userpassword and w.useremail = :useremail")})
public class WlsUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private Integer userid;
    @Lob
    @Size(max = 32700)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 8)
    @Column(name = "USERPHONENUMBER")
    private String userphonenumber;
    @Lob
    @Size(max = 32700)
    @Column(name = "USEREMAIL")
    private String useremail;
    @Size(max = 8)
    @Column(name = "USERPASSWORD")
    private String userpassword;
    @Lob
    @Size(max = 32700)
    @Column(name = "USERSEQN")
    private String userseqn;
    @Lob
    @Size(max = 32700)
    @Column(name = "USERSEAN")
    private String usersean;

    public WlsUser() {
    }

    public WlsUser(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphonenumber() {
        return userphonenumber;
    }

    public void setUserphonenumber(String userphonenumber) {
        this.userphonenumber = userphonenumber;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserseqn() {
        return userseqn;
    }

    public void setUserseqn(String userseqn) {
        this.userseqn = userseqn;
    }

    public String getUsersean() {
        return usersean;
    }

    public void setUsersean(String usersean) {
        this.usersean = usersean;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WlsUser)) {
            return false;
        }
        WlsUser other = (WlsUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WlsUser[ userid=" + userid + " ]";
    }
    
}
