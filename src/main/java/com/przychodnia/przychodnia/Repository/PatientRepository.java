package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * from pacjent p where p.login = :login AND p.password = :password", nativeQuery = true)
    List<Patient> findByLoginAndPassword(String login, String password);

    @Query(value = "SELECT * from pacjent p where p.first_name = :firstName OR p.last_name = :lastName OR p.pesel = :pesel", nativeQuery = true)
    List<Patient> findByFirstNameLastNamePesel(String firstName, String lastName, String pesel);
}
