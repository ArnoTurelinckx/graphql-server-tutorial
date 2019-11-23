package com.axxes.graphql.spqr.resolver;

import com.axxes.graphql.core.model.CompetenceCenter;
import com.axxes.graphql.core.repository.EmployeeRepository;
import com.axxes.graphql.spqr.dto.CompetenceCenterDto;
import com.axxes.graphql.spqr.dto.EmployeeDto;
import com.axxes.graphql.spqr.dto.support.DtoMapper;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Component
public class Mutation {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper dtoMapper;

    public Mutation(EmployeeRepository employeeRepository, DtoMapper dtoMapper) {
        this.employeeRepository = employeeRepository;
        this.dtoMapper = dtoMapper;
    }

    @GraphQLMutation
    public EmployeeDto createEmployee(
            @GraphQLArgument(name = "firstName") String firstName,
            @GraphQLArgument(name = "lastName") String lastName,
            @GraphQLArgument(name = "email") String email,
            @GraphQLArgument(name = "competenceCenters") Set<CompetenceCenterDto> competenceCenters) {
        return dtoMapper.toDto(employeeRepository.create(firstName, lastName, email, toDomain(competenceCenters)));
    }

    private Set<CompetenceCenter> toDomain(Set<CompetenceCenterDto> competenceCenters) {
        return competenceCenters.stream()
                .map(dtoMapper::toDomain)
                .collect(toSet());
    }
}
