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
    private final String firstName;
    private final String lastName;
    private final String location;
    private final byte[] image;

    public Users(long id, String firstName, String lastName, String location, byte[] image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocation() {
        return location;
    }

    public byte[] getImage() {
        return image;
    }
}
