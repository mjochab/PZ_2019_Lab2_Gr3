package com.przychodnia.przychodnia.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Aktualnosci")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime datetime;

    private String title;

    private String content;

    public News() {
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
        this.datetime = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
