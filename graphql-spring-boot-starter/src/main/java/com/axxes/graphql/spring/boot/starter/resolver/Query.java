package com.axxes.graphql.spring.boot.starter.resolver;

import com.axxes.graphql.core.repository.EmployeeRepository;
import com.axxes.graphql.spring.boot.starter.dto.CompetenceCenterDto;
import com.axxes.graphql.spring.boot.starter.dto.EmployeeDto;
import com.axxes.graphql.spring.boot.starter.dto.support.DtoMapper;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class Query implements GraphQLQueryResolver {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper dtoMapper;

    public Query(EmployeeRepository employeeRepository, DtoMapper dtoMapper) {
        this.employeeRepository = employeeRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<EmployeeDto> allEmployees(CompetenceCenterDto competenceCenterDto) {
        return employeeRepository.findAllEmployees(dtoMapper.toDomain(competenceCenterDto)).stream()
                .map(dtoMapper::toDto)
                .collect(toList());
    }
}
