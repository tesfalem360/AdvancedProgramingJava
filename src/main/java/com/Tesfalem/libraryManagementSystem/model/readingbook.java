package com.Tesfalem.libraryManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class readingbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;

    @ManyToOne
    @JoinColumn(name = "")
    private book book;


}
