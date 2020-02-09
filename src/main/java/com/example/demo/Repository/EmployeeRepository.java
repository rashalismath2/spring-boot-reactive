package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {

}
