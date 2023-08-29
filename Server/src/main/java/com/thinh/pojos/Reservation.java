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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngoc Thinh
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByIdReservation", query = "SELECT r FROM Reservation r WHERE r.idReservation = :idReservation"),
    @NamedQuery(name = "Reservation.findByTimeReservation", query = "SELECT r FROM Reservation r WHERE r.timeReservation = :timeReservation"),
    @NamedQuery(name = "Reservation.findByNumberSeatReservation", query = "SELECT r FROM Reservation r WHERE r.numberSeatReservation = :numberSeatReservation")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reservation")
    private Integer idReservation;
    @Size(max = 100)
    @Column(name = "time_reservation")
    private String timeReservation;
    @Column(name = "number_seat_reservation")
    private Integer numberSeatReservation;
    @JoinColumn(name = "id_customer_reservation", referencedColumnName = "id_customer")
    @ManyToOne
    private Customer idCustomerReservation;
    @JoinColumn(name = "id_trip_reservation", referencedColumnName = "id_trip")
    @ManyToOne
    private Trip idTripReservation;
    @OneToMany(mappedBy = "idReservationPayment")
    private Set<Payment> paymentSet;

    public Reservation() {
    }

    public Reservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getTimeReservation() {
        return timeReservation;
    }

    public void setTimeReservation(String timeReservation) {
        this.timeReservation = timeReservation;
    }

    public Integer getNumberSeatReservation() {
        return numberSeatReservation;
    }

    public void setNumberSeatReservation(Integer numberSeatReservation) {
        this.numberSeatReservation = numberSeatReservation;
    }

    public Customer getIdCustomerReservation() {
        return idCustomerReservation;
    }

    public void setIdCustomerReservation(Customer idCustomerReservation) {
        this.idCustomerReservation = idCustomerReservation;
    }

    public Trip getIdTripReservation() {
        return idTripReservation;
    }

    public void setIdTripReservation(Trip idTripReservation) {
        this.idTripReservation = idTripReservation;
    }

    @XmlTransient
    public Set<Payment> getPaymentSet() {
        return paymentSet;
    }

    public void setPaymentSet(Set<Payment> paymentSet) {
        this.paymentSet = paymentSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservation != null ? idReservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.idReservation == null && other.idReservation != null) || (this.idReservation != null && !this.idReservation.equals(other.idReservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinh.pojos.Reservation[ idReservation=" + idReservation + " ]";
    }
    
}
