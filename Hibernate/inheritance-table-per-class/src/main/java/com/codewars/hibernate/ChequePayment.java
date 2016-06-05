package com.codewars.hibernate;

import javax.persistence.*;

/**
 * Created by sulfur on 27.02.16.
 */


@Entity
@Table(name = "cheque_payment_full")
@AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "amount"))
})
public class ChequePayment extends Payment{

    @Column(name = "bank_id")
    private String bankId;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "ChequePayment{" +
                "bankId='" + bankId + '\'' +
                "} " + super.toString();
    }
}
