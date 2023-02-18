package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("model")
public interface ModelsRepeatedTest {
    @BeforeEach
    default void beforeAll(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running " + testInfo.getDisplayName()
                + "| " + repetitionInfo.getCurrentRepetition());
    }
}
