package com.example.demo;

import org.neo4j.springframework.data.core.schema.Id;
import reactor.util.annotation.Nullable;

public class ExampleNode {
    @Id
    WrappedId id;

    int value;

    public ExampleNode(@Nullable WrappedId id, int value) {
        this.id = id;
        this.value = value;
    }
}
