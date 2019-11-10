package com.axxes.graphql.java.model;

import com.axxes.graphql.java.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class Query implements GraphQLQueryResolver {

    private final EmployeeRepository employeeRepository;

    public Query(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> allEmployees(CompetenceCenter competenceCenter) {
        return employeeRepository.findAllEmployees(competenceCenter);
    }
}
