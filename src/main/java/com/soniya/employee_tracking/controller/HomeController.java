package com.soniya.employee_tracking.controller;

import ch.qos.logback.core.model.Model;
import com.soniya.employee_tracking.model.Employee;
import com.soniya.employee_tracking.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/registration")
    public String showRegistrationForm() {

        return "registration";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Corresponds to login.html in your templates folder
    }

    @GetMapping("/dashboard")
    public String showDashboard() {

        return "dashboard";
    }

    @GetMapping("/home")
    public String showHome() {

        return "home";
    }

    @GetMapping("/validation")
    public String showValidation(){
        return "validation";
    }


    @GetMapping("/total-employee")
    public String showEmployee(){
        return "total-employee";
    }

    @GetMapping("/department")
    public String showDepartment(){
        return "department";
    }

    @GetMapping("/contact")
    public String showContact(){
        return "contact";
    }

    @GetMapping("/about")
    public String showAbout(){
        return "about";
    }

    @GetMapping("/edit-employee")
    public String showEdit(){
//        System.out.println("Hey");
        return "edit-employee";
    }






}
