package com.nati.controller;

import com.nati.model.Employee;
import com.nati.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employee/")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "employees")
    public ResponseEntity<List<Employee>> findAll() {

        List<Employee> emp = employeeService.findAll();
        emp.forEach(action -> logger.info("{} ", action));
        return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
    }

    @GetMapping(value = "id/{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable("id") long id) {

        return new ResponseEntity<Optional<Employee>>(employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "create")
    public ResponseEntity<String> create(@RequestBody Employee emp) {

        employeeService.create(emp);
        logger.info("create Employee: {}", emp);
        return new ResponseEntity<String>("create Employee", HttpStatus.OK);
    }

    @DeleteMapping(value = "delete")
    public void delete() {

        employeeService.delete();
        logger.info("Deleted all Employee");
    }

    @DeleteMapping(value = "delete/id/{id}")
    public void deleteById(@PathVariable("id") long id) {

        employeeService.deleteById(id);
        logger.info("Delete Employee by id {}", id);
    }
}
