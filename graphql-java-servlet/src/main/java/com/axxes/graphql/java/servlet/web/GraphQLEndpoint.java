package com.axxes.graphql.java.servlet.web;

import com.axxes.graphql.core.repository.EmployeeRepository;
import com.axxes.graphql.java.servlet.dto.support.DtoMapper;
import com.axxes.graphql.java.servlet.resolver.Mutation;
import com.axxes.graphql.java.servlet.resolver.Query;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.servlet.SimpleGraphQLHttpServlet;
import graphql.servlet.config.GraphQLConfiguration;

public class GraphQLEndpoint extends SimpleGraphQLHttpServlet {

    private final EmployeeRepository employeeRepository = new EmployeeRepository();
    private final DtoMapper dtoMapper = new DtoMapper();

    @Override
    protected GraphQLConfiguration getConfiguration() {
        return GraphQLConfiguration
                .with(SchemaParser.newParser()
                        .file("schema.graphqls")
                        .resolvers(
                                new Query(employeeRepository, dtoMapper),
                                new Mutation(employeeRepository, dtoMapper)
                        )
                        .build()
                        .makeExecutableSchema())
                .build();
    }
}
