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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngoc Thinh
 */
@Entity
@Table(name = "driver")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findByIdDriver", query = "SELECT d FROM Driver d WHERE d.idDriver = :idDriver"),
    @NamedQuery(name = "Driver.findByFullNameDriver", query = "SELECT d FROM Driver d WHERE d.fullNameDriver = :fullNameDriver"),
    @NamedQuery(name = "Driver.findByEmailDriver", query = "SELECT d FROM Driver d WHERE d.emailDriver = :emailDriver"),
    @NamedQuery(name = "Driver.findByPhoneNumberDriver", query = "SELECT d FROM Driver d WHERE d.phoneNumberDriver = :phoneNumberDriver")})
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_driver")
    private Integer idDriver;
    @Size(max = 255)
    @Column(name = "full_name_driver")
    private String fullNameDriver;
    @Size(max = 255)
    @Column(name = "email_driver")
    private String emailDriver;
    @Size(max = 20)
    @Column(name = "phone_number_driver")
    private String phoneNumberDriver;
//    @OneToMany(mappedBy = "idDriverTrip")
//    private Set<Trip> tripSet;
//    @JoinColumn(name = "id_user_driver", referencedColumnName = "id_user")
//    @OneToOne
//    private User idUserDriver;
    @Column(name = "id_user_driver")
    private int idUserDriver;

    public Driver() {
    }

    public Driver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public String getFullNameDriver() {
        return fullNameDriver;
    }

    public void setFullNameDriver(String fullNameDriver) {
        this.fullNameDriver = fullNameDriver;
    }

    public String getEmailDriver() {
        return emailDriver;
    }

    public void setEmailDriver(String emailDriver) {
        this.emailDriver = emailDriver;
    }

    public String getPhoneNumberDriver() {
        return phoneNumberDriver;
    }

    public void setPhoneNumberDriver(String phoneNumberDriver) {
        this.phoneNumberDriver = phoneNumberDriver;
    }

//    @XmlTransient
//    public Set<Trip> getTripSet() {
//        return tripSet;
//    }
//
//    public void setTripSet(Set<Trip> tripSet) {
//        this.tripSet = tripSet;
//    }
//
//    public User getIdUserDriver() {
//        return idUserDriver;
//    }
//
//    public void setIdUserDriver(User idUserDriver) {
//        this.idUserDriver = idUserDriver;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idDriver != null ? idDriver.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Driver)) {
//            return false;
//        }
//        Driver other = (Driver) object;
//        if ((this.idDriver == null && other.idDriver != null) || (this.idDriver != null && !this.idDriver.equals(other.idDriver))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.thinh.pojos.Driver[ idDriver=" + idDriver + " ]";
//    }

    /**
     * @return the idUserDriver
     */
    public int getIdUserDriver() {
        return idUserDriver;
    }

    /**
     * @param idUserDriver the idUserDriver to set
     */
    public void setIdUserDriver(int idUserDriver) {
        this.idUserDriver = idUserDriver;
    }
    
}
