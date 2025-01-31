package com.soniya.employee_tracking.service;

import com.soniya.employee_tracking.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
    Employee update(int id, Employee employee);
    Employee findByName(String name);



   List<String> getDepartment();

    void delete(int id);

    long getEmployeeCount();


//    Map<String, Long> generateReport();

}