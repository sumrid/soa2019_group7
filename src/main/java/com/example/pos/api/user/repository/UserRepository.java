package com.example.pos.api.user.repository;

import com.example.pos.api.user.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Employee, Long> {

}
