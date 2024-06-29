package com.spring.cruddemo.rest;

import com.spring.cruddemo.Service.EmployeeService;
import com.spring.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService)
    {
        employeeService=theemployeeService;

    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee findById(@PathVariable int theId){
        Employee theEmployee =  employeeService.findById(theId);
        if(theEmployee==null){
            throw new RuntimeException("Employee id not found: "+theId);
        }
        return theEmployee;
    }
    //add mapping for post /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found: "+employeeId);

        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id:- "+employeeId;
    }
}
