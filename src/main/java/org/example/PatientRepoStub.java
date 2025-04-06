package org.example;

public class PatientRepoStub implements PatientRepo {
    @Override
    public Patient create(Patient patient) {
        return new Patient(1);
    }
}
