package com.example.testspring.controller;

import com.example.testspring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Trương Mạnh T", "Thái Nguyên"));
        studentList.add(new Student(2, "Trương Mạnh T", "Thái Nguyên"));
        studentList.add(new Student(3, "Trương Mạnh T", "Thái Nguyên"));
        studentList.add(new Student(4, "Trương Mạnh T", "Thái Nguyên"));
    }

    @GetMapping
    public String display(Model model) {
        model.addAttribute("student", studentList);
        return "view/list";
    }

    @GetMapping("showCreate")
    public String showCreate() {
        return "view/create";
    }

    @GetMapping("showUpdate")
    public String showUpdate(@RequestParam(value = "id", required = true) Integer id, Model model) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                model.addAttribute(student);
            }
        }
        return "view/update";
    }

    @GetMapping("delete")
    public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                break;
            }
        }
        return display(model);
    }

    @PostMapping("create")
    public String create(HttpServletRequest request, Model model) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        Student student = new Student(id, name, address);
        studentList.add(student);
        return display(model);
    }

    @PostMapping("update")
    public String update(@RequestParam(value = "id", required = true) Integer id, HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.set(studentList.indexOf(student), new Student(id, name, address));
                break;
            }
        }
        return display(model);
    }
}
