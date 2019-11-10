package com.axxes.graphql.java;

import com.axxes.graphql.java.web.GraphQLEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQLJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLJavaApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean graphQLServletRegistrationBean() {
        return new ServletRegistrationBean(new GraphQLEndpoint(), "/graphql");
    }
}
