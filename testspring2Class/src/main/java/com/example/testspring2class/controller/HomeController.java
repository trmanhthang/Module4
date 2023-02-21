package com.example.testspring2class.controller;

import com.example.testspring2class.model.Classroom;
import com.example.testspring2class.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    static List<Student> studentList;
    static {
        studentList.add(new Student(1, "Trương Mạnh T", "Thái Nguyên", new Classroom(1, "C10")));
        studentList.add(new Student(2, "Trương Mạnh T", "Thái Nguyên", new Classroom(2, "C11")));
        studentList.add(new Student(3, "Trương Mạnh T", "Thái Nguyên", new Classroom(3, "C12")));
        studentList.add(new Student(4, "Trương Mạnh T", "Thái Nguyên", new Classroom(2, "C11")));
        studentList.add(new Student(5, "Trương Mạnh T", "Thái Nguyên", new Classroom(1, "C10")));

    }

    @GetMapping
    public String display(Model model) {
        model.addAttribute("student", studentList);
        return "view/display";
    }
}
