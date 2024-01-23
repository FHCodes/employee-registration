package br.com.RegisterPeople.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private LocalDate hire_date;
    private Double salary;

    public Employee() {
    }

    public Employee(EmployeeData data) {
        this.name = data.name();
        this.position = data.position();
        this.hire_date = LocalDate.parse(data.hire_date());
        this.salary = data.salary();
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                '}';
    }

    public void updateData(updatingEmployeeData data) {
        this.name = data.name();
        this.position = data.position();
        this.hire_date = LocalDate.parse(data.hire_date());
        this.salary = data.salary();
    }
}
