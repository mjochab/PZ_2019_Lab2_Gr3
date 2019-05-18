package com.przychodnia.przychodnia.Repository;

import com.przychodnia.przychodnia.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(value = "SELECT * from aktualnosci order by RAND() LIMIT :random", nativeQuery = true)
    List<News> randomNews(int random);
}
