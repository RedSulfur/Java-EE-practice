package com.codewars.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by sulfur on 23.02.16.
 */

@Entity
@Table(name = "credit_payment")
@PrimaryKeyJoinColumn(name = "payment_id")
public class CreditCardPayment extends Payment{

    @Column(name = "credit_number")
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                "} " + super.toString();
    }
}
