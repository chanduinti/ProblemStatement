package com.bbtutorials.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bbtutorials.users.Service.City;

// CityRepository.java (Repository)
public interface CityRepository extends JpaRepository<City, Long> {
    // Add custom queries if needed
}