package com.axxes.graphql.java.servlet.resolver;

import com.axxes.graphql.core.model.CompetenceCenter;
import com.axxes.graphql.core.repository.EmployeeRepository;
import com.axxes.graphql.java.servlet.dto.CompetenceCenterDto;
import com.axxes.graphql.java.servlet.dto.EmployeeDto;
import com.axxes.graphql.java.servlet.dto.support.DtoMapper;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Mutation implements GraphQLMutationResolver {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper dtoMapper;

    public Mutation(EmployeeRepository employeeRepository, DtoMapper dtoMapper) {
        this.employeeRepository = employeeRepository;
        this.dtoMapper = dtoMapper;
    }

    public EmployeeDto createEmployee(String firstName, String lastName, String email, Set<CompetenceCenterDto> competenceCenters) {
        return dtoMapper.toDto(employeeRepository.create(firstName, lastName, email, toDomain(competenceCenters)));
    }

    private Set<CompetenceCenter> toDomain(Set<CompetenceCenterDto> competenceCenters) {
        return competenceCenters.stream()
                .map(dtoMapper::toDomain)
                .collect(toSet());
    }
}
