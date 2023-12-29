package com.jk.soulmatesbackendandroidapp.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Arrays;

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
    private final String token;
    private final String username;
    private final String password;
    private final boolean isActive;
    private final boolean isPremiumMember;

    public Timestamp getTokenTimeCreated() {
        return tokenTimeCreated;
    }

    private final Timestamp tokenTimeCreated;


    public Users(String firstName, String lastName, String location, byte[] image, String token, String username, String password, boolean isActive, boolean isPremiumMember, Timestamp tokenTimeCreated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.image = image;
        this.token = token;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.isPremiumMember = isPremiumMember;
        this.tokenTimeCreated = tokenTimeCreated;
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

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location='" + location + '\'' +
                ", image=" + Arrays.toString(image) +
                ", token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", isPremiumMember=" + isPremiumMember +
                ", tokenTimeCreated=" + tokenTimeCreated +
                '}';
    }
}