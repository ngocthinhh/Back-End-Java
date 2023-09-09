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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngoc Thinh
 */
@Entity
@Table(name = "route")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findByIdRoute", query = "SELECT r FROM Route r WHERE r.idRoute = :idRoute"),
    @NamedQuery(name = "Route.findByNameRoute", query = "SELECT r FROM Route r WHERE r.nameRoute = :nameRoute"),
    @NamedQuery(name = "Route.findByStartingPointRoute", query = "SELECT r FROM Route r WHERE r.startingPointRoute = :startingPointRoute"),
    @NamedQuery(name = "Route.findByDestinationRoute", query = "SELECT r FROM Route r WHERE r.destinationRoute = :destinationRoute")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_route")
    private String idRoute;
    @Size(max = 100)
    @Column(name = "name_route")
    private String nameRoute;
    @Size(max = 100)
    @Column(name = "starting_point_route")
    private String startingPointRoute;
    @Size(max = 100)
    @Column(name = "destination_route")
    private String destinationRoute;
//    @OneToMany(mappedBy = "idRouteTrip")
//    private Set<Trip> tripSet;

    public Route() {
    }

    public Route(String idRoute) {
        this.idRoute = idRoute;
    }

    public String getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(String idRoute) {
        this.idRoute = idRoute;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public String getStartingPointRoute() {
        return startingPointRoute;
    }

    public void setStartingPointRoute(String startingPointRoute) {
        this.startingPointRoute = startingPointRoute;
    }

    public String getDestinationRoute() {
        return destinationRoute;
    }

    public void setDestinationRoute(String destinationRoute) {
        this.destinationRoute = destinationRoute;
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
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idRoute != null ? idRoute.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Route)) {
//            return false;
//        }
//        Route other = (Route) object;
//        if ((this.idRoute == null && other.idRoute != null) || (this.idRoute != null && !this.idRoute.equals(other.idRoute))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.thinh.pojos.Route[ idRoute=" + idRoute + " ]";
//    }
    
}
