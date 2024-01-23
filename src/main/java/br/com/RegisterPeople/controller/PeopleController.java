package br.com.RegisterPeople.controller;

import br.com.RegisterPeople.model.Employee;
import br.com.RegisterPeople.model.EmployeeData;
import br.com.RegisterPeople.model.EmployeeRepository;
import br.com.RegisterPeople.model.updatingEmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class PeopleController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("")
    public String loadHome() {
        return "pages/home";
    }

    @GetMapping("/form")
    public String loadFormPage(Long id,Model model) {
        if (id != null) {
            var employee = repository.getReferenceById(id);
            model.addAttribute("employee",employee);
        };
        return "pages/form";
    }

    @GetMapping("/show-employees")
    public String loadShowEmployees(Model model) {
        model.addAttribute("listEmployee", repository.findAll());
        return "pages/showEmployees";
    }

    @PostMapping("/form")
    @Transactional
    public String registerEmployee(EmployeeData data) {
        Employee emp = new Employee(data);
        repository.save(emp);
        return "redirect:/form";
    }

    @PutMapping("/form")
    @Transactional
    public String updateEmployee(updatingEmployeeData data) {
        Employee emp = repository.getReferenceById(data.id());
        emp.updateData(data);
        return "redirect:/form";
    }

    @DeleteMapping("/show-employees")
    @Transactional
    public String employeeDelete(Long id) {
        repository.deleteById(id);
        return "redirect:/show-employees";
    }
}
