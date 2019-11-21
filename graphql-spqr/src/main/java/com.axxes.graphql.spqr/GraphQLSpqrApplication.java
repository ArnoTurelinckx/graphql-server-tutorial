package com.axxes.graphql.spqr;

import com.axxes.graphql.spqr.model.Mutation;
import com.axxes.graphql.spqr.model.Query;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQLSpqrApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLSpqrApplication.class, args);
    }

    @Bean
    public GraphQL graphQL(Query query, Mutation mutation) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withBasePackages("com.axxes.graphql.spqr.model")
                .withOperationsFromSingletons(query, mutation)
                .generate();
        return GraphQL.newGraphQL(schema).build();
    }
}
