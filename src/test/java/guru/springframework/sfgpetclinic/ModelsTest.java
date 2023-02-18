package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@Tag("model")
public interface ModelsTest {
    @BeforeEach
    default void beforeAll(TestInfo testInfo) {
        System.out.println("Running: " + testInfo.getDisplayName());
    }
}
