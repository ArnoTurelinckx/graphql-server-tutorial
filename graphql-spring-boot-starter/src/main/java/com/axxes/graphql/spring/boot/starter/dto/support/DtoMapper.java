package com.axxes.graphql.spring.boot.starter.dto.support;

import com.axxes.graphql.core.model.CompetenceCenter;
import com.axxes.graphql.core.model.Employee;
import com.axxes.graphql.spring.boot.starter.dto.CompetenceCenterDto;
import com.axxes.graphql.spring.boot.starter.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
                employee.getCompetenceCenters().stream().map(this::toDto).collect(toSet())
        );
    }
}
