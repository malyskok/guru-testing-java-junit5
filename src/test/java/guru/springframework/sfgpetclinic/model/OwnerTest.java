package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ControllersTest;
import guru.springframework.sfgpetclinic.ModelsTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelsTest {

    @Test
    void testDependents(){
        // Given
        Owner owner = new Owner(1L, "John", "Doe");
        owner.setCity("New York");

        // Then
        assertAll("Props test",
                () -> assertAll("Person props",
                        () -> assertEquals("John", owner.getFirstName(), "wrong firstname"),
                        () -> assertEquals("Doe", owner.getLastName(), "wrong lastname")),
                () -> assertAll("Owner props",
                        () -> assertEquals("New York", owner.getCity(), "wrong city"),
                        () -> assertNull(owner.getTelephone(), "telephone is not null"))
        );

        assertThat("New York", is(owner.getCity()));
    }
}