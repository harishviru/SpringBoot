package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
