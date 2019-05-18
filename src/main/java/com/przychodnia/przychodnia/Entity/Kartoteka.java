package com.przychodnia.przychodnia.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Kartotekas")
public class Kartoteka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime datetime;

    @OneToOne
    private Patient patient;

    @OneToMany
    private List<Wizyta> wizytaList;

    @OneToMany
    private List<Presciption> presciptions;

    public Kartoteka() {
        this.datetime = LocalDateTime.now();
    }

    public List<Presciption> getPresciptions() {
        return presciptions;
    }

    public void setPresciptions(List<Presciption> presciptions) {
        this.presciptions = presciptions;
    }

    public List<Wizyta> getWizytaList() {
        return wizytaList;
    }

    public void setWizytaList(List<Wizyta> wizytaList) {
        this.wizytaList = wizytaList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return patient.getFirstName()+" "+patient.getLastName();
    }
}
