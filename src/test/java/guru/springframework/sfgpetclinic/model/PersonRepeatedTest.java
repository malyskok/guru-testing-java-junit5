package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelsRepeatedTest;
import guru.springframework.sfgpetclinic.ModelsTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonRepeatedTest implements ModelsRepeatedTest {

    @RepeatedTest(value = 2, name = "{displayName} : {currentRepetition} of {totalRepetitions}")
    @DisplayName("My repeated test")
    void myRepeatedTest() {
        //impl
    }

    @RepeatedTest(2)
    @DisplayName("My repeated test with DI")
    void myRepeatedTestDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(2)
    @DisplayName("One more my repeated test with DI")
    void oneMoreMyRepeatedTest() {
        //impl
    }
}