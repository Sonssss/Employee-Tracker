package com.soniya.employee_tracking.repo;

import com.soniya.employee_tracking.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

        Employee findByName(String name);



}
