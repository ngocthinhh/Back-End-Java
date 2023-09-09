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
@Table(name = "customer")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByIdCustomer", query = "SELECT c FROM Customer c WHERE c.idCustomer = :idCustomer"),
    @NamedQuery(name = "Customer.findByFullNameCustomer", query = "SELECT c FROM Customer c WHERE c.fullNameCustomer = :fullNameCustomer"),
    @NamedQuery(name = "Customer.findByEmailCustomer", query = "SELECT c FROM Customer c WHERE c.emailCustomer = :emailCustomer"),
    @NamedQuery(name = "Customer.findByPhoneNumberCustomer", query = "SELECT c FROM Customer c WHERE c.phoneNumberCustomer = :phoneNumberCustomer")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Size(max = 255)
    @Column(name = "full_name_customer")
    private String fullNameCustomer;
    @Size(max = 255)
    @Column(name = "email_customer")
    private String emailCustomer;
    @Size(max = 20)
    @Column(name = "phone_number_customer")
    private String phoneNumberCustomer;
//    @OneToMany(mappedBy = "idCustomerFeedback")
//    private Set<Feedback> feedbackSet;
//    @OneToMany(mappedBy = "idCustomerReservation")
//    private Set<Reservation> reservationSet;
//    @OneToMany(mappedBy = "idCustomerPayment")
//    private Set<Payment> paymentSet;
//    @JoinColumn(name = "id_user_customer", referencedColumnName = "id_user")
//    @OneToOne
//    private User idUserCustomer;
    @Column(name = "id_user_customer")
    private int idUserCustomer;

    public Customer() {
    }

    public Customer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFullNameCustomer() {
        return fullNameCustomer;
    }

    public void setFullNameCustomer(String fullNameCustomer) {
        this.fullNameCustomer = fullNameCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

//    @XmlTransient
//    public Set<Feedback> getFeedbackSet() {
//        return feedbackSet;
//    }
//
//    public void setFeedbackSet(Set<Feedback> feedbackSet) {
//        this.feedbackSet = feedbackSet;
//    }
//
//    @XmlTransient
//    public Set<Reservation> getReservationSet() {
//        return reservationSet;
//    }
//
//    public void setReservationSet(Set<Reservation> reservationSet) {
//        this.reservationSet = reservationSet;
//    }
//
//    @XmlTransient
//    public Set<Payment> getPaymentSet() {
//        return paymentSet;
//    }
//
//    public void setPaymentSet(Set<Payment> paymentSet) {
//        this.paymentSet = paymentSet;
//    }

//    public User getIdUserCustomer() {
//        return idUserCustomer;
//    }
//
//    public void setIdUserCustomer(User idUserCustomer) {
//        this.setIdUserCustomer(idUserCustomer);
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Customer)) {
//            return false;
//        }
//        Customer other = (Customer) object;
//        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.thinh.pojos.Customer[ idCustomer=" + idCustomer + " ]";
//    }

    /**
     * @return the idUserCustomer
     */
    public int getIdUserCustomer() {
        return idUserCustomer;
    }

    /**
     * @param idUserCustomer the idUserCustomer to set
     */
    public void setIdUserCustomer(int idUserCustomer) {
        this.idUserCustomer = idUserCustomer;
    }
    
}
