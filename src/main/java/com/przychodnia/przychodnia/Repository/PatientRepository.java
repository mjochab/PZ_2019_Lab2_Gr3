package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * from p_patient p where p.login = :login AND p.password = :password", nativeQuery = true)
    List<Patient> findByLoginAndPassword(String login, String password);
}
