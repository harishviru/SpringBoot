package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

}
