package com.jolt.employee.service;

import java.util.List;

import com.jolt.employee.model.Employee;
import com.jolt.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // Create
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    // Read
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // Delete
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    // Update
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());

        return employeeRepository.save(emp);
    }
}
