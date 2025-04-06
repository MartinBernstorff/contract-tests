package org.example;

import java.util.HashMap;
import java.util.Map;

public class PatientRepoFake implements PatientRepo {
    private final Map<Integer, Patient> patients = new HashMap<>();

    @Override
    public Patient create(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }

        if (patients.containsKey(patient.id())) {
            throw new IllegalArgumentException(
                    "Patient with ID " + patient.id() + " already exists"
            );
        }

        // Copy to keep item in map immutable
        patients.put(patient.id(), patient.copy());

        // Copy to keep item in map immutable
        return patient.copy();
    }
}