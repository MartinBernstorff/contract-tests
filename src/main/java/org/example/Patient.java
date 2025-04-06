package org.example;

public record Patient(int id) {
    public Patient {
        if (id < 0) {
            throw new IllegalArgumentException("ID must be non-negative");
        }
    }

    public Patient copy() {
        return new Patient(id);
    }
}
