package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testNewPerson(){
        // Given
        Person person = new Person(1L, "John", "Doe");

        // Then
        assertAll("Testing Person props",
                () -> assertEquals("John", person.getFirstName(), "wrong firstname"),
                () -> assertEquals("Doe", person.getLastName(), "wrong lastname"));
    }

}