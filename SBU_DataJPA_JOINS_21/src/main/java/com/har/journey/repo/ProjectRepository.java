package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
