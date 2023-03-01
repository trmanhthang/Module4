package com.example.demohibernate.controller;

import com.example.demohibernate.model.Employee;
import com.example.demohibernate.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employeeList")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping
    public String findAll(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "list";
    }
}
