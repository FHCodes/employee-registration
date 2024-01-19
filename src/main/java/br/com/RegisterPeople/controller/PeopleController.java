package br.com.RegisterPeople.controller;

import br.com.RegisterPeople.model.Employee;
import br.com.RegisterPeople.model.EmployeeData;
import br.com.RegisterPeople.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeopleController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("")
    public String loadHome() {
        return "pages/home";
    }

    @GetMapping("/form")
    public String loadFormPage() {
        return "pages/form";
    }

    @GetMapping("/show-employees")
    public String loadShowEmployees(Model model) {
        model.addAttribute("listEmployee", repository.findAll());
        return "pages/showEmployees";
    }

    @PostMapping("/form")
    public String registerEmployee(EmployeeData data) {
        Employee emp = new Employee(data);
        repository.save(emp);
        return "pages/form";
    }
}
