package com.axxes.graphql.spring.boot.starter.resolver;

import com.axxes.graphql.core.model.CompetenceCenter;
import com.axxes.graphql.core.repository.EmployeeRepository;
import com.axxes.graphql.spring.boot.starter.dto.CompetenceCenterDto;
import com.axxes.graphql.spring.boot.starter.dto.EmployeeDto;
import com.axxes.graphql.spring.boot.starter.dto.support.DtoMapper;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper dtoMapper;

    public Mutation(EmployeeRepository employeeRepository, DtoMapper dtoMapper) {
        this.employeeRepository = employeeRepository;
        this.dtoMapper = dtoMapper;
    }

    public EmployeeDto createEmployee(String firstName, String lastName, String email, Set<CompetenceCenterDto> competenceCenterDtos) {
        return dtoMapper.toDto(employeeRepository.create(firstName, lastName, email, toDomain(competenceCenterDtos)));
    }

    private Set<CompetenceCenter> toDomain(Set<CompetenceCenterDto> competenceCenters) {
        return competenceCenters.stream()
                .map(dtoMapper::toDomain)
                .collect(toSet());
    }
}
