package com.jolt.employee.controller;

import com.jolt.employee.model.Employee;
import com.jolt.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }

    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Employee> readEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable(value="empId") Long id, @RequestBody Employee empDetails) {
        return employeeService.updateEmployee(id, empDetails);
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable(value="empId") Long id) {
        employeeService.deleteEmployee(id);
    }
}
