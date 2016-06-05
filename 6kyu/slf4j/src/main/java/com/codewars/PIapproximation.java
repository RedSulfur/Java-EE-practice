package com.codewars;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Created by sulfur on 17.02.16.
 */
public class PIapproximation {

    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static String iterPi2String(Double epsilon) {

        double error, sum = 1, n = 1;
        int iter = 0, sign = 1;

        do {
            n = Math.abs(n);
            sign = sign*(-1);
            n = (n  + 2) * sign;
            sum += 1 / n;
            iter++;
            error = Math.PI - Math.abs(sum*4);
            log.debug("error, sum : {} {}", error,sum*4);

        } while (Math.abs(error) > epsilon);

        iter++;
        sum = new BigDecimal(sum).setScale(12, RoundingMode.DOWN).doubleValue();

        String result = Double.toString(sum*4);
        log.debug("error, sum : {} {}", error,sum*4);

        result = result.substring(0,12);

        log.debug("******************************************************\n\n");
        log.debug("Pi : {} {}", result, error);

        return "[" + iter + ", " +  result + "]";
    }
}
