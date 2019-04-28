package com.project.user_service.repository;

import com.project.user_service.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByname(String name);
}
