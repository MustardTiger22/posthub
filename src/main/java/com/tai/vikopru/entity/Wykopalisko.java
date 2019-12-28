package com.tai.vikopru.entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@Table(name = "wykopalisko")
public class Wykopalisko {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_wykopalisko")
    private Long idWykopalisko;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "rating_plus")
    private Long ratingPlus;

    @Column(name = "rating_minus")
    private Long ratingMinus;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "source_url")
    private String sourceUrl;

    @Column(name = "image_src")
    private String imageSrc;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    private User user;

    public Wykopalisko() {
    }

    public Wykopalisko(String title,
                       String description,
                       Long ratingPlus,
                       Long ratingMinus,
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



}
