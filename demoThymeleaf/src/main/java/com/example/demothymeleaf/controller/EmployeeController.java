package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Employee;
import com.example.demothymeleaf.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @GetMapping
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("employeeList", employeeService.findAll());
        return modelAndView;
    }

    @GetMapping("showCreate")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @GetMapping("showEdit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return "redirect:/employee";
    }

    @PostMapping("save")
    public String save(Employee employee) {
        employeeService.add(employee);
        return "redirect:/employee";
    }


}
