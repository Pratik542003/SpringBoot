package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
