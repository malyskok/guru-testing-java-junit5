package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @ValueSource(strings = {"Jim", "David", "Joe"})
    void parametrizedTest(String name) {
        System.out.println(name);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 1"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("CSV From File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getargs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    static Stream<Arguments> getargs() {
        return Stream.of(
                Arguments.of("FL", 5, 1),
                Arguments.of("OH", 2, 8),
                Arguments.of("MI", 3, 5));
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }
}