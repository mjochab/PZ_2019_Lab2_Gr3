package com.przychodnia.przychodnia.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "p_presciption")
public class Presciption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Kartoteka kartoteka;

    @ManyToOne
    private Doctor doctor;

    private LocalDateTime localDateTime;

    public Presciption() {
    }

    public Presciption(LocalDateTime localDateTime, Doctor doctor) {
        this.localDateTime = localDateTime;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kartoteka getKartoteka() {
        return kartoteka;
    }

    public void setKartoteka(Kartoteka kartoteka) {
        this.kartoteka = kartoteka;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
