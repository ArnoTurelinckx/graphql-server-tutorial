package com.axxes.graphql.spqr;

import com.axxes.graphql.core.CoreConfiguration;
import com.axxes.graphql.spqr.resolver.Mutation;
import com.axxes.graphql.spqr.resolver.Query;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CoreConfiguration.class)
public class GraphQLSpqrApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLSpqrApplication.class, args);
    }

    @Bean
    public GraphQL graphQL(Query query, Mutation mutation) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withBasePackages("com.axxes.graphql.spqr.dto", "com.axxes.graphql.spqr.resolver")
                .withOperationsFromSingletons(query, mutation)
                .generate();
        return GraphQL.newGraphQL(schema).build();
    }
}
