package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllersTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllersTest {

    private IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Tests if index returns correct view")
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "wrong index returned");
        assertEquals("index", controller.index(), () -> "wrong index returned" +
                "and now you see this" +
                "expensive long message");

        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> controller.oupsHandler());
    }

    @Test
    void testTimeOutPass() {

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);

            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPrempt() {

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here 2342342342342");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase("guru"));
        assertTrue(true);
    }

    @Test
    void testAssumptionTrueFails() {
        assumeTrue("GURU".equalsIgnoreCase("NOOB"));
        assertTrue(true);
    }

    @Test
    void testEnvAssumptionTrue() {
        assumeTrue("index".equalsIgnoreCase(System.getenv("API_NAME")));
        assertTrue(true);
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindowsOS() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }
}