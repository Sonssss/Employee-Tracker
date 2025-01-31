package com.soniya.employee_tracking.controller;

import ch.qos.logback.core.model.Model;
import com.soniya.employee_tracking.model.Employee;
import com.soniya.employee_tracking.repo.EmployeeRepository;
import com.soniya.employee_tracking.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //mapping for registration
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody @Valid Employee employee){
        employeeService.add(employee);
        return ResponseEntity.ok("Employee registered successfully!");
    }

    //mapping for valid registration
    @PostMapping("/registration")
    public String registerEmployee(@ModelAttribute Employee employee, Model model){
        employeeService.add(employee);
        return "redirect:/validation";
    }

    //mapping for login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Employee loginRequest) {
        String name = loginRequest.getName();
        String password = loginRequest.getPassword();

        // Find the employee by name
        Employee employee = employeeService.findByName(name);

        // Check if the employee exists and if the password matches
        if (employee != null && employee.getPassword().equals(password)) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    //fetch all employee data to display on the table
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();  // Assuming you have this method
        return ResponseEntity.ok(employees);
    }

    //fetch all employee records
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.findAll();
    }

    //maps this method to http GET request for specific ID in the URL
//    @GetMapping("/{id}")
//    public Employee  getById(@PathVariable int id) {
//        return employeeService.findById(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Optional<Employee> employee = Optional.ofNullable(employeeService.findById(id));
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

//    @PutMapping("/{id}")
//    Employee update(@PathVariable int id, @RequestBody @Valid Employee employee) {
//        return employeeService.add(employee);
//    }

    @PutMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.update(employee.getId(), employee);
        return "redirect:/total-employee";  // Redirect to the employee list page after update
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        try {
            employeeService.delete(id);
            return ResponseEntity.ok("Employee deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        // Call your service method to update the employee
        Employee updatedEmployee = employeeService.update(id, employee);
        return ResponseEntity.ok(updatedEmployee); // Respond with 200 OK
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getEmployeeCount(){
        long count=employeeService.getEmployeeCount();
        return ResponseEntity.ok(count);
    }

}
