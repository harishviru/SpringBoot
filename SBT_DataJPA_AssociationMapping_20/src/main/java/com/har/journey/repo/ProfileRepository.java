package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
