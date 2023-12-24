package com.Tesfalem.libraryManagementSystem.repository;

import com.Tesfalem.libraryManagementSystem.model.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Irepositorybook extends JpaRepository<book,Long> {
}

