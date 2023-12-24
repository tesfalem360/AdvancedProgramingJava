package com.Tesfalem.libraryManagementSystem.repository;

import com.Tesfalem.libraryManagementSystem.model.readingbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Irepositoryreadingbook extends JpaRepository<readingbook,Long> {
}
