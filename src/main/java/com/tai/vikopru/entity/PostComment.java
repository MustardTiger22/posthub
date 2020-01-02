package com.tai.vikopru.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@Table(name = "wykopalisko_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_wykopalisko_comment")
    Integer idComment;
    @Column(name = "comment_content")
    String content;
    @Column(name = "rating_plus")
    Integer ratingPlus;
    @Column(name = "rating_minus")
    Integer ratingMinus;
    @Column(name = "timestamp")
    Timestamp timestamp;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    User user;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_wykopalisko")
    Post post;

    public PostComment() {
    }

    public PostComment(String content) {
        this.content = content;
        this.ratingPlus = 0;
        this.ratingMinus = 0;
        this.timestamp = Timestamp.from(Instant.now());
    }

}
