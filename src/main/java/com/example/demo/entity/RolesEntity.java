package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;
}


