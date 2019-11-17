package com.axxes.graphql.spqr.model;

import com.axxes.graphql.spqr.repository.EmployeeRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query {

    private final EmployeeRepository employeeRepository;

    public Query(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GraphQLQuery
    public List<Employee> allEmployees(@GraphQLArgument(name = "competenceCenter", description = "returns all employees, filters out employees for the given competenceCenter") CompetenceCenter competenceCenter) {
        return employeeRepository.findAllEmployees(competenceCenter);
    }
}
