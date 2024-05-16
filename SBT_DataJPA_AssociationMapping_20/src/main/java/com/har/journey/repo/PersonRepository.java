package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
