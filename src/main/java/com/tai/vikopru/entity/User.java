package com.tai.vikopru.entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "wykop_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "avatar_path")
    private String avatarPath;

    @Column(name = "create_date")
    private Timestamp createDate;

    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Wykopalisko> wykopaliska;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String username,
                String password,
                String email,
                String firstName,
                String lastName,
                String gender,
                String avatarPath) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.avatarPath = avatarPath;
        this.createDate = Timestamp.from(Instant.now());
    }

    public User(String username,
                String password,
                String email,
                String firstName,
                String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = "M";
        this.createDate = Timestamp.from(Instant.now());
    }

    public void addWykopalisko(Wykopalisko wykopalisko) {
        if(wykopaliska == null) {
            wykopaliska = new ArrayList<>();
        }
        wykopaliska.add(wykopalisko);
        wykopalisko.setUser(this);
    }
}
