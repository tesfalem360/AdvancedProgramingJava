package com.Tesfalem.libraryManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class book {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String name;
    private String author;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<readingbook> readingbookList;


}