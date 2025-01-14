package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelsTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelsTest {

    @Test
    void testNewPerson() {
        // Given
        Person person = new Person(1L, "John", "Doe");

        // Then
        assertAll("Testing Person props",
                () -> assertEquals("John", person.getFirstName(), "wrong firstname"),
                () -> assertEquals("Doe", person.getLastName(), "wrong lastname"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} of {totalRepetitions}")
    @DisplayName("My repeated test")
    void myRepeatedTest() {
        //impl
    }

    @RepeatedTest(2)
    @DisplayName("My repeated test with DI")
    void myRepeatedTestDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(6)
    @DisplayName("One more my repeated test with DI")
    void oneMoreMyRepeatedTest() {
        //impl
    }
}