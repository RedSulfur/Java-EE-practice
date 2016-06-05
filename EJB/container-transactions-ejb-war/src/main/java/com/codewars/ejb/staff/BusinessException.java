package com.codewars.ejb.staff;

import javax.ejb.ApplicationException;

/**
 * Created by sulfur on 16.03.16.
 */

@ApplicationException(rollback = true)
public class BusinessException extends Exception{

    public BusinessException(String message) {super(message);}

    public BusinessException(Throwable cause) {super(cause);}

}
