package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Entity.Kartoteka;
import com.przychodnia.przychodnia.Entity.Presciption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresciptionsRepository extends JpaRepository<Presciption,Long> {


    List<Presciption> findByDoctor(Doctor doctor);

    List<Presciption> findByKartoteka(Kartoteka kartoteka);

}
