package com.axxes.graphql.java.servlet.model;

import com.axxes.graphql.java.servlet.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private final EmployeeRepository employeeRepository;

    public Query(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> allEmployees(CompetenceCenter competenceCenter) {
        return employeeRepository.findAllEmployees(competenceCenter);
    }
}
