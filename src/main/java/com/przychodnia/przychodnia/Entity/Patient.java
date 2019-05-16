package com.przychodnia.przychodnia.Entity;

import javax.persistence.*;

@Entity
@Table(name = "p_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String pesel;

    private String tel_number;

    private String address;

    @OneToOne
    private Kartoteka kartoteka;

    public Patient() {
    }

    public Patient(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Patient(String login, String password, String email, String firstName, String lastName, String pesel, String tel_number, String address, Kartoteka kartoteka) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.tel_number = tel_number;
        this.address = address;
        this.kartoteka = kartoteka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Kartoteka getKartoteka() {
        return kartoteka;
    }

    public void setKartoteka(Kartoteka kartoteka) {
        this.kartoteka = kartoteka;
    }
}
