package br.com.RegisterPeople.controller;

import br.com.RegisterPeople.model.EmployeeData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeopleController {

    @GetMapping("")
    public String loadHome() {
        return "home";
    }

    @GetMapping("/form")
    public String loadFormPage() {
        return "pages/form";
    }

    @PostMapping("/form")
    public String registerEmployee(EmployeeData employee) {
        return "pages/form";
    }
}
