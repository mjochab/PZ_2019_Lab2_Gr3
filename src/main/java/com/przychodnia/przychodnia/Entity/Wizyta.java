package com.przychodnia.przychodnia.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Wizyta")
public class Wizyta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Kartoteka kartoteka;

    @ManyToOne
    private Doctor doctor;

    private LocalDateTime localDateTime;


    public Wizyta() {
    }

    public Wizyta(LocalDateTime localDateTime, Doctor doctor) {
        this.localDateTime = localDateTime;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Kartoteka getKartoteka() {
        return kartoteka;
    }

    public void setKartoteka(Kartoteka kartoteka) {
        this.kartoteka = kartoteka;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
