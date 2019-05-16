package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {

    @Query(value = "SELECT * from p_receptionist p where p.login = :login AND p.password = :password", nativeQuery = true)
    List<Receptionist> findByLoginAndPassword(String login, String password);
}
