package com.thiaghoul.dslist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GameList {

    @Id
    private Long id;

    private String name;
}
