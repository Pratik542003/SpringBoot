package com.spring.cruddemo.DAO;

import com.spring.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a queyr
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

        //execute query and get result
        List<Employee> employees = theQuery.getResultList();

        //return result
    return  employees;
    }
}
