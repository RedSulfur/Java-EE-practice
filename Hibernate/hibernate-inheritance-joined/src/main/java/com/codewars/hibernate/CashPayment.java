package com.codewars.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by sulfur on 23.02.16.
 */

@Entity
@Table(name = "cash_payment")
@PrimaryKeyJoinColumn(name = "payment_id")
//по какой колонке связывать эту таблицу с родительской сущностью
//какая колонкая является обьединяющей для этих сущностей
public class CashPayment extends Payment{

    @Column(name = "cash_desk")
    private String cashDesk;

    public String getCashDesk() {
        return cashDesk;
    }

    public void setCashDesk(String cashDesk) {
        this.cashDesk = cashDesk;
    }

    @Override
    public String toString() {
        return "CashPayment{" +
                "cashDesk='" + cashDesk + '\'' +
                '}' + super.toString();
    }
}
