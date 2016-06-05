package com.codewars.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by sulfur on 26.02.16.
 */

@Entity
@Table(name = "actors")
public class Actor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "actor_name")
    private Long actorName;

    public Actor() {
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getActorName() {
        return actorName;
    }

    public void setActorName(Long actorName) {
        this.actorName = actorName;
    }

    @Override
    public String toString() {
        return "actorName=" + actorName;
    }
}
