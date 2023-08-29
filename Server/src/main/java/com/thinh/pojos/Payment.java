/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.pojos;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ngoc Thinh
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByIdPayment", query = "SELECT p FROM Payment p WHERE p.idPayment = :idPayment"),
    @NamedQuery(name = "Payment.findByTimePayment", query = "SELECT p FROM Payment p WHERE p.timePayment = :timePayment"),
    @NamedQuery(name = "Payment.findByTypePayment", query = "SELECT p FROM Payment p WHERE p.typePayment = :typePayment")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payment")
    private Integer idPayment;
    @Size(max = 100)
    @Column(name = "time_payment")
    private String timePayment;
    @Size(max = 7)
    @Column(name = "type_payment")
    private String typePayment;
    @JoinColumn(name = "id_customer_payment", referencedColumnName = "id_customer")
    @ManyToOne
    private Customer idCustomerPayment;
    @JoinColumn(name = "id_reservation_payment", referencedColumnName = "id_reservation")
    @ManyToOne
    private Reservation idReservationPayment;

    public Payment() {
    }

    public Payment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getTimePayment() {
        return timePayment;
    }

    public void setTimePayment(String timePayment) {
        this.timePayment = timePayment;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    public Customer getIdCustomerPayment() {
        return idCustomerPayment;
    }

    public void setIdCustomerPayment(Customer idCustomerPayment) {
        this.idCustomerPayment = idCustomerPayment;
    }

    public Reservation getIdReservationPayment() {
        return idReservationPayment;
    }

    public void setIdReservationPayment(Reservation idReservationPayment) {
        this.idReservationPayment = idReservationPayment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayment != null ? idPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idPayment == null && other.idPayment != null) || (this.idPayment != null && !this.idPayment.equals(other.idPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinh.pojos.Payment[ idPayment=" + idPayment + " ]";
    }
    
}
