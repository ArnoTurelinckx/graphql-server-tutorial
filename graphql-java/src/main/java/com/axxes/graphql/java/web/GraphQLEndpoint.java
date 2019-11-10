package com.axxes.graphql.java.web;

import com.axxes.graphql.java.model.Mutation;
import com.axxes.graphql.java.model.Query;
import com.axxes.graphql.java.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.servlet.SimpleGraphQLHttpServlet;
import graphql.servlet.config.GraphQLConfiguration;

public class GraphQLEndpoint extends SimpleGraphQLHttpServlet {

    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    protected GraphQLConfiguration getConfiguration() {
        return GraphQLConfiguration
                .with(SchemaParser.newParser()
                        .file("schema.graphqls")
                        .resolvers(
                                new Query(employeeRepository),
                                new Mutation(employeeRepository)
                        )
                        .build()
                        .makeExecutableSchema())
                .build();
    }
}
