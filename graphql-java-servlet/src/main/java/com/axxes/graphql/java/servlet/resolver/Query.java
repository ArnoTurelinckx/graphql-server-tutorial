package com.axxes.graphql.java.servlet.resolver;

import com.axxes.graphql.core.repository.EmployeeRepository;
import com.axxes.graphql.java.servlet.dto.CompetenceCenterDto;
import com.axxes.graphql.java.servlet.dto.EmployeeDto;
import com.axxes.graphql.java.servlet.dto.support.DtoMapper;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Query implements GraphQLQueryResolver {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper dtoMapper;

    public Query(EmployeeRepository employeeRepository, DtoMapper dtoMapper) {
        this.employeeRepository = employeeRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<EmployeeDto> allEmployees(CompetenceCenterDto competenceCenter) {
        return employeeRepository.findAllEmployees(dtoMapper.toDomain(competenceCenter)).stream()
                .map(dtoMapper::toDto)
                .collect(toList());
    }
}
