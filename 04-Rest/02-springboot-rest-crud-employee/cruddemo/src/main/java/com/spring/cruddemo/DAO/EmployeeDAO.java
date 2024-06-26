package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}