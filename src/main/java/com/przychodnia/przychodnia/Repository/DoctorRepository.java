package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
