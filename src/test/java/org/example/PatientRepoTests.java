package org.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;


class PatientRepoTests {
    @TestFactory
    Stream<DynamicTest> testFake() {
        return new PatientRepoContract().test(() -> new PatientRepoFake());
    }

    @TestFactory
    Stream<DynamicTest> testStub() {
        return new PatientRepoContract().test(() -> new PatientRepoStub());
    }
}