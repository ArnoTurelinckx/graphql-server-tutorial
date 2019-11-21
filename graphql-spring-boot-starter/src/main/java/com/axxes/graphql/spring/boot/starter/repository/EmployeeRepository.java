package com.axxes.graphql.spring.boot.starter.repository;

import com.axxes.graphql.spring.boot.starter.model.CompetenceCenter;
import com.axxes.graphql.spring.boot.starter.model.Employee;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Repository
public class EmployeeRepository {

    private final AtomicLong employeeId = new AtomicLong();
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(nextId(), "Arno", "Turelinckx", "", Set.of(CompetenceCenter.JAVA)),
            new Employee(nextId(), "John", "Johnson", "", Set.of(CompetenceCenter.DOTNET))
    ));

    public List<Employee> findAllEmployees(CompetenceCenter competenceCenter) {
        return employees.stream()
                .filter(EmployeeInGivenCompetenceCenter(competenceCenter))
                .collect(toList());
    }

    private long nextId() {
        return employeeId.incrementAndGet();
    }

    @NotNull
    private Predicate<Employee> EmployeeInGivenCompetenceCenter(CompetenceCenter competenceCenter) {
        return e -> Optional.ofNullable(competenceCenter)
                .map(cc -> e.getCompetenceCenters().contains(competenceCenter))
                .orElse(true);
    }

    public Employee create(String firstName, String lastName, String email, Set<CompetenceCenter> competenceCenters) {
        var employee = new Employee(nextId(), firstName, lastName, email, competenceCenters);
        employees.add(employee);
        return employee;
    }
}
