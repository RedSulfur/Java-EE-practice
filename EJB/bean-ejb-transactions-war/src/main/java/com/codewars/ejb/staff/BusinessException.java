package com.codewars.ejb.staff;

import javax.ejb.ApplicationException;

/**
 * Created by sulfur on 14.03.16.
 */
public class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }


}