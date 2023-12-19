package com.jk.soulmatesbackendandroidapp.models;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @SequenceGenerator(
            name = "id",
            sequenceName = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id"
    )
    private long id;
    private String firstName;
    private String lastName;
    private String location;
    private byte[] image;
}
