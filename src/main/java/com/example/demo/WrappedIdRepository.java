package com.example.demo;

import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;

public interface WrappedIdRepository extends ReactiveNeo4jRepository<ExampleNode, WrappedId> {
}
