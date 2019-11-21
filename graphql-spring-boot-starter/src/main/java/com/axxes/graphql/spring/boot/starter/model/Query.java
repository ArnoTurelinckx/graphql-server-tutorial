package com.axxes.graphql.spring.boot.starter.model;

import com.axxes.graphql.spring.boot.starter.repository.EmployeeRepository;
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
