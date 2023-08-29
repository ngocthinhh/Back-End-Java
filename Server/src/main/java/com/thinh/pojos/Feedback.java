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
import javax.persistence.Lob;
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
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findByIdFeedback", query = "SELECT f FROM Feedback f WHERE f.idFeedback = :idFeedback"),
    @NamedQuery(name = "Feedback.findByRatingFeedback", query = "SELECT f FROM Feedback f WHERE f.ratingFeedback = :ratingFeedback")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_feedback")
    private Integer idFeedback;
    @Lob
    @Size(max = 65535)
    @Column(name = "text_feedback")
    private String textFeedback;
    @Column(name = "rating_feedback")
    private Integer ratingFeedback;
    @JoinColumn(name = "id_customer_feedback", referencedColumnName = "id_customer")
    @ManyToOne
    private Customer idCustomerFeedback;
    @JoinColumn(name = "id_trip_feedback", referencedColumnName = "id_trip")
    @ManyToOne
    private Trip idTripFeedback;

    public Feedback() {
    }

    public Feedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Integer getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getTextFeedback() {
        return textFeedback;
    }

    public void setTextFeedback(String textFeedback) {
        this.textFeedback = textFeedback;
    }

    public Integer getRatingFeedback() {
        return ratingFeedback;
    }

    public void setRatingFeedback(Integer ratingFeedback) {
        this.ratingFeedback = ratingFeedback;
    }

    public Customer getIdCustomerFeedback() {
        return idCustomerFeedback;
    }

    public void setIdCustomerFeedback(Customer idCustomerFeedback) {
        this.idCustomerFeedback = idCustomerFeedback;
    }

    public Trip getIdTripFeedback() {
        return idTripFeedback;
    }

    public void setIdTripFeedback(Trip idTripFeedback) {
        this.idTripFeedback = idTripFeedback;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeedback != null ? idFeedback.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.idFeedback == null && other.idFeedback != null) || (this.idFeedback != null && !this.idFeedback.equals(other.idFeedback))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinh.pojos.Feedback[ idFeedback=" + idFeedback + " ]";
    }
    
}
