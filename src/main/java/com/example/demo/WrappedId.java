package com.example.demo;

import org.neo4j.driver.Value;
import org.neo4j.driver.internal.value.IntegerValue;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Set;

public class WrappedId {
    private final long id;

    public WrappedId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    static class Converter implements GenericConverter {

        @Override
        public Set<ConvertiblePair> getConvertibleTypes() {
            return Set.of(new ConvertiblePair(WrappedId.class, Value.class), new ConvertiblePair(Value.class, WrappedId.class));
        }

        @Override
        public Object convert(Object o, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
            if (o == null) return null;

            if (WrappedId.class.isAssignableFrom(typeDescriptor.getType())) {
                return new IntegerValue(((WrappedId) o).id);
            } else {
                return new WrappedId(((Value) o).asLong());
            }
        }
    }
}
