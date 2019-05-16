package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.Kartoteka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KartotekaRepository extends JpaRepository<Kartoteka, Long> {
}
