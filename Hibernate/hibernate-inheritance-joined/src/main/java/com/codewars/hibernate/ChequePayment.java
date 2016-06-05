package com.codewars.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by sulfur on 23.02.16.
 */

@Entity
@Table(name = "cheque_payment")
@PrimaryKeyJoinColumn(name = "payment_id")
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
                '}' + super.toString();
    }
}
