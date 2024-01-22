package com.amin.thymleaf.controller;

import com.amin.thymleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${operatingSystem}")
    private List<String> operatingSystems;

    @GetMapping("/studentForm")
    public String showForm(Model model) {
        var theStudent = new Student();

        model.addAttribute("student", theStudent);

        model.addAttribute("countries", countries);

        model.addAttribute("languages", languages);

        model.addAttribute("systems", operatingSystems);

        return "student-form";
    }

    @PostMapping("/v1/processStudentForm")
    public String processStudent(@ModelAttribute("student") Student theStudent) {

        //Log
        System.out.println("The student: " + theStudent.getFirstName() + " " +
                theStudent.getLastName() + " from " + theStudent.getCountry() + " is registered!");


        return "student-confirmation";
    }
}
