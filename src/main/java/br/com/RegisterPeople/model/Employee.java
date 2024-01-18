package br.com.RegisterPeople.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

    private String name;
    private String position;
    private LocalDate hire_date;
    private Double salary;

    public Employee(EmployeeData data) {
        this.name = data.name();
        this.position = data.position();
        this.hire_date = LocalDate.parse(data.hire_date());
        this.salary = data.salary();
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public Double getSalary() {
        return salary;
    }

    public String dateFormatting(LocalDate hire_date){
        return hire_date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String salaryFormatting(Double salary) {
        String formattedSalary = String.format("%.2f", salary);
        formattedSalary = "R$ " + formattedSalary;
        return formattedSalary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                '}';
    }
}
