package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
