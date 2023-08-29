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
@Table(name = "trip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t"),
    @NamedQuery(name = "Trip.findByIdTrip", query = "SELECT t FROM Trip t WHERE t.idTrip = :idTrip"),
    @NamedQuery(name = "Trip.findByDepartureTimeTrip", query = "SELECT t FROM Trip t WHERE t.departureTimeTrip = :departureTimeTrip"),
    @NamedQuery(name = "Trip.findByPriceTrip", query = "SELECT t FROM Trip t WHERE t.priceTrip = :priceTrip")})
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trip")
    private Integer idTrip;
    @Size(max = 100)
    @Column(name = "departure_time_trip")
    private String departureTimeTrip;
    @Column(name = "price_trip")
    private Integer priceTrip;
    @OneToMany(mappedBy = "idTripFeedback")
    private Set<Feedback> feedbackSet;
    @JoinColumn(name = "id_driver_trip", referencedColumnName = "id_driver")
    @ManyToOne
    private Driver idDriverTrip;
    @JoinColumn(name = "id_route_trip", referencedColumnName = "id_route")
    @ManyToOne
    private Route idRouteTrip;
    @OneToMany(mappedBy = "idTripReservation")
    private Set<Reservation> reservationSet;

    public Trip() {
    }

    public Trip(Integer idTrip) {
        this.idTrip = idTrip;
    }

    public Integer getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(Integer idTrip) {
        this.idTrip = idTrip;
    }

    public String getDepartureTimeTrip() {
        return departureTimeTrip;
    }

    public void setDepartureTimeTrip(String departureTimeTrip) {
        this.departureTimeTrip = departureTimeTrip;
    }

    public Integer getPriceTrip() {
        return priceTrip;
    }

    public void setPriceTrip(Integer priceTrip) {
        this.priceTrip = priceTrip;
    }

    @XmlTransient
    public Set<Feedback> getFeedbackSet() {
        return feedbackSet;
    }

    public void setFeedbackSet(Set<Feedback> feedbackSet) {
        this.feedbackSet = feedbackSet;
    }

    public Driver getIdDriverTrip() {
        return idDriverTrip;
    }

    public void setIdDriverTrip(Driver idDriverTrip) {
        this.idDriverTrip = idDriverTrip;
    }

    public Route getIdRouteTrip() {
        return idRouteTrip;
    }

    public void setIdRouteTrip(Route idRouteTrip) {
        this.idRouteTrip = idRouteTrip;
    }

    @XmlTransient
    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrip != null ? idTrip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.idTrip == null && other.idTrip != null) || (this.idTrip != null && !this.idTrip.equals(other.idTrip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinh.pojos.Trip[ idTrip=" + idTrip + " ]";
    }
    
}
