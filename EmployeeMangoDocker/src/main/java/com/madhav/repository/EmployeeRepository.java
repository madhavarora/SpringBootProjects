package com.madhav.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.madhav.model.Employee;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
