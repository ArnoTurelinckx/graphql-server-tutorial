package com.axxes.graphql.java.model;

import java.util.Set;

public class Employee {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Set<CompetenceCenter> competenceCenters;

    public Employee(Long id, String firstName, String lastName, String email, Set<CompetenceCenter> competenceCenters) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.competenceCenters = competenceCenters;
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

    public Set<CompetenceCenter> getCompetenceCenters() {
        return competenceCenters;
    }
}
