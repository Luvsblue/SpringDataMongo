package com.SpringDataMongo.SpringDataMongo.EmployeeRepository;

import com.SpringDataMongo.SpringDataMongo.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
