package com.axxes.graphql.spqr.model;

import com.axxes.graphql.spqr.repository.EmployeeRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Mutation {

    private final EmployeeRepository employeeRepository;

    public Mutation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GraphQLMutation
    public Employee createEmployee(
            @GraphQLArgument(name = "firstName") String firstName,
            @GraphQLArgument(name = "lastName") String lastName,
            @GraphQLArgument(name = "email") String email,
            @GraphQLArgument(name = "competenceCenters") Set<CompetenceCenter> competenceCenters) {
        return employeeRepository.create(firstName, lastName, email, competenceCenters);
    }
}
