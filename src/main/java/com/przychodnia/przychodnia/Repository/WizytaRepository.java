package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Entity.Kartoteka;
import com.przychodnia.przychodnia.Entity.Wizyta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WizytaRepository extends JpaRepository<Wizyta, Long> {


    List<Wizyta> findByDoctor(Doctor doctor);

    List<Wizyta> findByKartoteka(Kartoteka kartoteka);


}
