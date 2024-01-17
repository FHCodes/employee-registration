package br.com.RegisterPeople.model;

import java.time.LocalDate;

public record EmployeeData(String name, String position, LocalDate hire_date, Double salary) {

}
