package com.nati.service;

import com.nati.model.Employee;
import com.nati.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {

        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    public void create(Employee employee) {

        employeeRepository.save(employee);
    }

    public void delete() {

        employeeRepository.deleteAll();
    }

    public void deleteById(long id) {

        employeeRepository.deleteById(id);
    }


}
