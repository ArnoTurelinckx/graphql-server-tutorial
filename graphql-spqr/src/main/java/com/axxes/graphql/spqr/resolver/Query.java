package com.axxes.graphql.spqr.resolver;

import com.axxes.graphql.core.repository.EmployeeRepository;
import com.axxes.graphql.spqr.dto.CompetenceCenterDto;
import com.axxes.graphql.spqr.dto.EmployeeDto;
import com.axxes.graphql.spqr.dto.support.DtoMapper;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class Query {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper dtoMapper;

    public Query(EmployeeRepository employeeRepository, DtoMapper dtoMapper) {
        this.employeeRepository = employeeRepository;
        this.dtoMapper = dtoMapper;
    }

    @GraphQLQuery
    public List<EmployeeDto> allEmployees(@GraphQLArgument(name = "competenceCenter", description = "returns all employees, filters out employees for the given competenceCenter") CompetenceCenterDto competenceCenter) {
        return employeeRepository.findAllEmployees(dtoMapper.toDomain(competenceCenter)).stream()
                .map(dtoMapper::toDto)
                .collect(toList());
    }
}
