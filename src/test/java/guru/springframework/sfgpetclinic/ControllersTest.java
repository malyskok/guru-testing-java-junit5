package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("controller")
public interface ControllersTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll for controller tag");
    }
}
