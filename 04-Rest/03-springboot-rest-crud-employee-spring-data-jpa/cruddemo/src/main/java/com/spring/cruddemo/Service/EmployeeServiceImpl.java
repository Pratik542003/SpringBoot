package com.spring.cruddemo.Service;

import com.spring.cruddemo.DAO.EmployeeRepository;
import com.spring.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theemployeerepository){
        employeeRepository = theemployeerepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result  = employeeRepository.findById(theId);

        Employee theemployee = null;
        if(result.isPresent()){
            theemployee = result.get();
        }
        else{
            throw new RuntimeException(("Did not find employee id :- "+ theId));
        }
        return theemployee ;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
