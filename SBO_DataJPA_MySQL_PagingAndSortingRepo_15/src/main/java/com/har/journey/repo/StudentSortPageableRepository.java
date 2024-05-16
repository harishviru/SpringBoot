package com.har.journey.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.har.journey.model.Student;

public interface StudentSortPageableRepository extends PagingAndSortingRepository<Student, Integer>{

}
