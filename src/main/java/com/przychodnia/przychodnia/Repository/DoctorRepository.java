package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query(value = "SELECT * from doktor p where p.login = :login AND p.password = :password", nativeQuery = true)
    List<Doctor> findByLoginAndPassword(String login, String password);
}
