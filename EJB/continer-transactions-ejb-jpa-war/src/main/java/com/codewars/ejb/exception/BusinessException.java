package com.codewars.ejb.exception;

import javax.ejb.ApplicationException;

/**
 * Created by sulfur on 17.03.16.
 */

@ApplicationException(rollback = true)
public class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
