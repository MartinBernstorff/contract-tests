package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PatientRepoMocks {
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
