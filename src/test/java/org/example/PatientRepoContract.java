package org.example;

import org.junit.jupiter.api.DynamicTest;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class PatientRepoContract {
    Stream<DynamicTest> test(Supplier<PatientRepo> patientRepo) {
        return Stream.of(
            dynamicTest("create should save and return patient with ID", () -> {
                Patient patient = new Patient(0);
                Patient savedPatient = patientRepo.get().create(patient);

                assertNotNull(savedPatient, "Saved patient should not be null");
                assertEquals(patient.id(), savedPatient.id(), "Saved patient should have the same ID");
            }),

            dynamicTest("create with null patient should throw exception", () -> {
                assertThrows(IllegalArgumentException.class, () -> {
                    patientRepo.get().create(null);
                });
            }),

            // Test: create with valid patient should return new instance
            dynamicTest("create with valid patient should return new instance", () -> {
                Patient patient = new Patient(0);
                Patient savedPatient = patientRepo.get().create(patient);

                assertNotSame(patient, savedPatient,
                "Created patient should be a different instance than the input patient");
            })
        );
    }
}