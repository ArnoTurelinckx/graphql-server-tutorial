package com.axxes.graphql.java.servlet.model;

import com.axxes.graphql.java.servlet.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final EmployeeRepository employeeRepository;

    public Mutation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(String firstName, String lastName, String email, Set<CompetenceCenter> competenceCenters) {
        return employeeRepository.create(firstName, lastName, email, competenceCenters);
    }
}
