package com.axxes.graphql.spqr.spring.boot.starter.service;

import com.axxes.graphql.core.model.CompetenceCenter;
import com.axxes.graphql.core.repository.EmployeeRepository;
import com.axxes.graphql.spqr.spring.boot.starter.dto.CompetenceCenterDto;
import com.axxes.graphql.spqr.spring.boot.starter.dto.EmployeeDto;
import com.axxes.graphql.spqr.spring.boot.starter.dto.support.DtoMapper;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@GraphQLApi
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper dtoMapper;

    public EmployeeService(EmployeeRepository employeeRepository, DtoMapper dtoMapper) {
        this.employeeRepository = employeeRepository;
        this.dtoMapper = dtoMapper;
    }

    @GraphQLQuery
    public List<EmployeeDto> allEmployees(@GraphQLArgument(name = "competenceCenter", description = "returns all employees, filters out employees for the given competenceCenter") CompetenceCenterDto competenceCenter) {
        return employeeRepository.findAllEmployees(dtoMapper.toDomain(competenceCenter)).stream()
                .map(dtoMapper::toDto)
                .collect(toList());
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
