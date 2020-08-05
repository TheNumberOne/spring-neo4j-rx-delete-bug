package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    WrappedIdRepository repository;

    @Override
    public void run(String... args) {
        WrappedId id = new WrappedId(12345);
        repository.save(new ExampleNode(id)).block();

        try {
            repository.deleteById(id).block();
        } catch (InvalidDataAccessResourceUsageException e) {
            // This exception always happens.
            logger.error("Failed to delete by custom id", e);
        }
    }
}

