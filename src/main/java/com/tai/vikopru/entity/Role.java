package com.tai.vikopru.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_role")
    private Long id;

    @Column(name = "role_name")
    private String name;

    public Role() {
    }
}
