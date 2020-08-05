package com.example.demo;

import org.neo4j.springframework.data.core.convert.Neo4jConversions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@SpringBootApplication
public class SpringNeo4jDeleteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNeo4jDeleteApplication.class, args);
    }
    @Bean
    Neo4jConversions neo4jConversions() {
        return new Neo4jConversions(Collections.singleton(new WrappedId.Converter()));
    }
}
