package org.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class PatientRepoTests {
    @TestFactory
    Stream<DynamicTest> testFake() {
        return new PatientRepoContract().test(() -> new PatientRepoFake());
    }

    @TestFactory
    Stream<DynamicTest> testStub() {
        return new PatientRepoContract().test(() -> new PatientRepoStub());
    }

    @Test
    void testMock() {
        var patientRepo = mock(PatientRepo.class);
        when(patientRepo.create(any(Patient.class))).thenAnswer(invocation -> {
            Patient patient = invocation.getArgument(0);
            return new Patient(patient.id());
        });

        var patient = new Patient(0);
        var savedPatient = patientRepo.create(patient);

        assertNotNull(savedPatient, "Saved patient should not be null");
    }
}