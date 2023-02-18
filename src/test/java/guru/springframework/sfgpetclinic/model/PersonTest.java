package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelsTest {

    @Test
    void testNewPerson(){
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
}