package com.example.demo;

import org.neo4j.springframework.data.core.schema.Id;
import reactor.util.annotation.Nullable;

public class ExampleNode {
    @Id
    WrappedId id;

    public ExampleNode(@Nullable WrappedId id) {
        this.id = id;
    }
}
