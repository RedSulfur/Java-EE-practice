package com.codewars;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by sulfur on 12.03.16.
 */

@Local
public interface ActorEJBLocal {

    List<Actor> getActors();
}
