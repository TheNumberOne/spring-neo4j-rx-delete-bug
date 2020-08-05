package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    final WrappedIdRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public Runner(WrappedIdRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        WrappedId id = new WrappedId(12345);
        repository.save(new ExampleNode(id, 5)).block();

        try {
            repository.deleteById(id).block();
        } catch (InvalidDataAccessResourceUsageException e) {
            // This exception always happens.
            logger.error("Failed to delete by id", e);
        }
    }
}

