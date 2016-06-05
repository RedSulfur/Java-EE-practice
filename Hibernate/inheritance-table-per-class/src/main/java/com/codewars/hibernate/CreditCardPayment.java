package com.codewars.hibernate;

import javax.persistence.*;

/**
 * Created by sulfur on 27.02.16.
 */

@Entity
@Table(name = "credit_payment_full")
@AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "amount"))
})
public class CreditCardPayment extends Payment{

    @Column(name = "credit_number")
    private String creditNumber;

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "creditNumber='" + creditNumber + '\'' +
                "} " + super.toString();
    }
}
