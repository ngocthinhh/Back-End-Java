/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.pojos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Ngoc Thinh
 */
@Entity
@Table(name = "user")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "User.findByUsernameUser", query = "SELECT u FROM User u WHERE u.usernameUser = :usernameUser"),
    @NamedQuery(name = "User.findByPasswordUser", query = "SELECT u FROM User u WHERE u.passwordUser = :passwordUser"),
    @NamedQuery(name = "User.findByRoleUser", query = "SELECT u FROM User u WHERE u.roleUser = :roleUser"),
    @NamedQuery(name = "User.findByAvatarUser", query = "SELECT u FROM User u WHERE u.avatarUser = :avatarUser")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Size(max = 100)
    @Column(name = "username_user")
    private String usernameUser;
    @Size(max = 100)
    @Column(name = "password_user")
    private String passwordUser;
    @Size(max = 100)
    @Column(name = "full_name_user")
    private String fullNameUser;
    @Size(max = 100)
    @Column(name = "phone_number_user")
    private String phoneNumberUser;
    @Size(max = 8)
    @Column(name = "role_user")
    private String roleUser;
    @Size(max = 255)
    @Column(name = "avatar_user")
    private String avatarUser;
//    @OneToOne(mappedBy = "idUserDriver")
//    private Driver driver;
//    @OneToOne(mappedBy = "idUserEmployee")
//    private Employee employee;
//    @OneToOne(mappedBy = "idUserCustomer")
//    private Customer customer;
    
    @Transient
    private MultipartFile file;

    public User() {
//        this.idUser = -1;
//        this.usernameUser = null;
//        this.passwordUser = null;
//        this.avatarUser = null;
//        this.customer = null;
//        this.employee = null;
//        this.driver = null;
//        this.roleUser = null;
//        this.file = null;
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public String getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(String avatarUser) {
        this.avatarUser = avatarUser;
    }

//    @XmlTransient
//    public Driver getDriver() {
//        return driver;
//    }
//
//    public void setDriver(Driver driver) {
//        this.driver = driver;
//    }
//
//    @XmlTransient
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    @XmlTransient
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idUser != null ? idUser.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof User)) {
//            return false;
//        }
//        User other = (User) object;
//        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.thinh.pojos.User[ idUser=" + idUser + " ]";
//    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the fullNameUser
     */
    public String getFullNameUser() {
        return fullNameUser;
    }

    /**
     * @param fullNameUser the fullNameUser to set
     */
    public void setFullNameUser(String fullNameUser) {
        this.fullNameUser = fullNameUser;
    }

    /**
     * @return the phoneNumberUser
     */
    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    /**
     * @param phoneNumberUser the phoneNumberUser to set
     */
    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }
    
}
