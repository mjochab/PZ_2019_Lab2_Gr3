package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
}