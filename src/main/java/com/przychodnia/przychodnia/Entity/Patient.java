package com.przychodnia.przychodnia.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Pacjent")
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

    private String phone;

    private String address;

    private String postcode;

    @ManyToOne
    private Doctor doctor;

    @OneToOne
    private Kartoteka kartoteka;

    public Patient() {
    }

    public Patient(String login, String password, Doctor doctor) {
        this.login = login;
        this.password = password;
        this.doctor = doctor;
    }

    public Patient(String login, String password, String email, String firstName, String lastName, String pesel,
                   String tel_number, String address, Kartoteka kartoteka, Doctor doctor) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.phone = tel_number;
        this.address = address;
        this.kartoteka = kartoteka;
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}
