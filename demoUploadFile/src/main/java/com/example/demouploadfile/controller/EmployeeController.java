package com.example.demouploadfile.controller;

import com.example.demouploadfile.model.Brand;
import com.example.demouploadfile.model.Employee;
import com.example.demouploadfile.service.BrandServiceImpl;
import com.example.demouploadfile.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private BrandServiceImpl brandService;

    @GetMapping
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView("view/list");
        modelAndView.addObject("employeeList", employeeService.findAll());
        return modelAndView;
    }

    @GetMapping("/showCreate")
    public String showCreateForm(Model model) {
        model.addAttribute("employeeList", new Employee());
        model.addAttribute("brandList", brandService.findAll());
        return "view/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/showForm/{id}")
    public ModelAndView showForm(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("view/form");
        modelAndView.addObject("employeeList", employeeService.findById(id));
        modelAndView.addObject("brandList", brandService.findAll());
        return modelAndView;
    }
}
