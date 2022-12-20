package jpaShop.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {
    private String Director;
    private String Actor;
}
