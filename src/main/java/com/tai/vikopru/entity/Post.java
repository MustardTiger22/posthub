package com.tai.vikopru.entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@Table(name = "wykopalisko")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_wykopalisko")
    private Integer idPost;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "rating_plus")
    private Integer ratingPlus;

    @Column(name = "rating_minus")
    private Integer ratingMinus;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "source_url")
    private String sourceUrl;

    @Column(name = "image_src")
    private String imageSrc;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    private User user;

    public Post() {
    }

    public Post(String title,
                String description,
                Integer ratingPlus,
                Integer ratingMinus,
                String sourceUrl,
                String imageSrc) {
        this.title = title;
        this.description = description;
        this.ratingPlus = ratingPlus;
        this.ratingMinus = ratingMinus;
        this.timestamp = Timestamp.from(Instant.now());
        this.sourceUrl = sourceUrl;
        this.imageSrc = imageSrc;
    }

    public Post(String title, String description, String imageSrc, String sourceUrl) {
        this.title = title;
        this.description = description;
        this.sourceUrl = sourceUrl;
        this.imageSrc = imageSrc;
        this.timestamp = Timestamp.from(Instant.now());
        this.ratingPlus = 0;
        this.ratingMinus = 0;
    }

    @Override
    public String toString() {
        return "Wykopalisko{" +
                "idWykopalisko=" + idPost +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", imageSrc='" + imageSrc + '\'' +
                '}';
    }
}
