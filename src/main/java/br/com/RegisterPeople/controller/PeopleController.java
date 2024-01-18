package br.com.RegisterPeople.controller;

import br.com.RegisterPeople.model.Employee;
import br.com.RegisterPeople.model.EmployeeData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PeopleController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping("")
    public String loadHome() {
        return "home";
    }

    @GetMapping("/form")
    public String loadFormPage() {
        return "pages/form";
    }

    @GetMapping("/show-employees")
    public String loadShowEmployees(Model model) {
        model.addAttribute("listEmployee",employees);
        return "pages/showEmployees";
    }

    @PostMapping("/form")
    public String registerEmployee(EmployeeData data) {
        Employee emp = new Employee(data);
        employees.add(emp);


        System.out.println(employees);
        return "pages/form";
    }
}
