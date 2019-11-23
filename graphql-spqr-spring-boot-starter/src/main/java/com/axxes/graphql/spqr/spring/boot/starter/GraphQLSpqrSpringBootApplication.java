package com.axxes.graphql.spqr.spring.boot.starter;

import com.axxes.graphql.core.CoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CoreConfiguration.class)
public class GraphQLSpqrSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLSpqrSpringBootApplication.class, args);
    }
}
