package com.codewars;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by sulfur on 12.03.16.
 */

@Remote
public interface ActorEJBRemote {
    List<Actor> getActors();
}
