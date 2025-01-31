package com.soniya.employee_tracking.service.impl;


import com.soniya.employee_tracking.model.Employee;
import com.soniya.employee_tracking.repo.EmployeeRepository;
import com.soniya.employee_tracking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

//    @Override
//    public Employee findById(int id) {
//        return employeeRepository.findById(id).get();
//    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

//    @Override
//    public Employee update(int id, Employee employee) {
//        Employee byId = findById(id);
//        if(byId == null) {
//
//        }
//        return employeeRepository.save(employee);
//    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<String> getDepartment() {
        return employeeRepository.findAll()
                .stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Employee update(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(existingEmployee);
    }

    public void delete(int id) {
        // Check if employee exists before deletion
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public Employee findById(int id){
        return employeeRepository.findById(id).orElse(null);
    }


    public long getEmployeeCount(){
        return employeeRepository.count();
    }



}
