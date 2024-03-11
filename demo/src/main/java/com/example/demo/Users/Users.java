package com.example.demo.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
@Entity
@Table

public class Users {
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Character type;
    private String hashedPassword;
    private String add_country;
    private String add_city;
    private String add_state;
    private String add_street;
    private String add_street2;
    private String add_zip_code;
    private LocalDate dob;

    public Users(){

    }
    public Users(Long id,
                String firstName,
                String lastName,
                String email,
                Character type,
                String hashedPassword,
                String add_country,
                String add_city,
                String add_state,
                String add_street,
                String add_street2,
                String add_zip_code,
                LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
        this.hashedPassword = hashedPassword;
        this.add_country = add_country;
        this.add_city = add_city;
        this.add_state = add_state;
        this.add_street = add_street;
        this.add_street2 = add_street2;
        this.add_zip_code = add_zip_code;
        this.dob = dob;
    }

    public Users(String firstName,
                String lastName,
                String email,
                Character type,
                String hashedPassword,
                String add_country,
                String add_city,
                String add_state,
                String add_street,
                String add_street2,
                String add_zip_code,
                LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
        this.hashedPassword = hashedPassword;
        this.add_country = add_country;
        this.add_city = add_city;
        this.add_state = add_state;
        this.add_street = add_street;
        this.add_street2 = add_street2;
        this.add_zip_code = add_zip_code;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getAdd_country() {
        return add_country;
    }

    public void setAdd_country(String add_country) {
        this.add_country = add_country;
    }

    public String getAdd_city() {
        return add_city;
    }

    public void setAdd_city(String add_city) {
        this.add_city = add_city;
    }

    public String getAdd_state() {
        return add_state;
    }

    public void setAdd_state(String add_state) {
        this.add_state = add_state;
    }

    public String getAdd_street() {
        return add_street;
    }

    public void setAdd_street(String add_street) {
        this.add_street = add_street;
    }

    public String getAdd_street2() {
        return add_street2;
    }

    public void setAdd_street2(String add_street2) {
        this.add_street2 = add_street2;
    }

    public String getAdd_zip_code() {
        return add_zip_code;
    }

    public void setAdd_zip_code(String add_zip_code) {
        this.add_zip_code = add_zip_code;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", add_country='" + add_country + '\'' +
                ", add_city='" + add_city + '\'' +
                ", add_state='" + add_state + '\'' +
                ", add_street='" + add_street + '\'' +
                ", add_street2='" + add_street2 + '\'' +
                ", add_zip_code='" + add_zip_code + '\'' +
                ", dob=" + dob +
                '}';
    }
}

