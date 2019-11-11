package com.axxes.graphql.java.servlet;

import com.axxes.graphql.java.servlet.web.GraphQLEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQLJavaServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLJavaServletApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean graphQLServletRegistrationBean() {
        return new ServletRegistrationBean(new GraphQLEndpoint(), "/graphql");
    }
}
