package com.amin.thymleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    //need a controller method to show the initial HTML form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String prcessForm() {
        return "helloworld";
    }

    @RequestMapping("/v2/processForm")
    public String prcessFormV2(HttpServletRequest request, Model model) {
        var studentName = request.getParameter("studentName").toUpperCase();
        var result = "Yo! " + studentName;

        model.addAttribute("message", result);

        return "helloworld";
    }

    @GetMapping("/v3/processForm")
    public String processFormV3(@RequestParam("studentName") String theName, Model model) {
        var studentName = theName.toUpperCase();
        var result = "Hello Student: " + studentName;

        model.addAttribute("message", result);

        return "helloworld";
    }

}
