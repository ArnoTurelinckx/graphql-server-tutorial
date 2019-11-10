package com.axxes.graphql.java.model;

import com.axxes.graphql.java.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;
import java.util.Set;

public class Mutation implements GraphQLMutationResolver {

    private final EmployeeRepository employeeRepository;

    public Mutation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(String firstName, String lastName, String email, Set<CompetenceCenter> competenceCenters) {
        return employeeRepository.create(firstName, lastName, email, competenceCenters);
    }
}
