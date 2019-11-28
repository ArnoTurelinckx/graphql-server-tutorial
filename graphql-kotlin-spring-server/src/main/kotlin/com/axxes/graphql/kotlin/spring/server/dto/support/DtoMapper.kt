package com.axxes.graphql.kotlin.spring.server.dto.support;

import com.axxes.graphql.core.model.CompetenceCenter;
import com.axxes.graphql.core.model.Employee;
import com.axxes.graphql.kotlin.spring.server.dto.CompetenceCenterDto;
import com.axxes.graphql.kotlin.spring.server.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Component
public class DtoMapper {

    public CompetenceCenter toDomain(CompetenceCenterDto competenceCenter) {
        return Optional.ofNullable(competenceCenter)
                .map(cc -> CompetenceCenter.valueOf(cc.name()))
                .orElse(null);
    }

    public CompetenceCenterDto toDto(CompetenceCenter competenceCenter) {
        return CompetenceCenterDto.valueOf(competenceCenter.name());
    }

    public EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getCompetenceCenters().stream().map(this::toDto).collect(toList())
        );
    }
}
