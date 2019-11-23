package com.axxes.graphql.spring.boot.starter.dto;

import java.util.Set;

public class EmployeeDto {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Set<CompetenceCenterDto> competenceCenterDtos;

    public EmployeeDto(Long id, String firstName, String lastName, String email, Set<CompetenceCenterDto> competenceCenterDtos) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.competenceCenterDtos = competenceCenterDtos;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<CompetenceCenterDto> getCompetenceCenters() {
        return competenceCenterDtos;
    }
}
