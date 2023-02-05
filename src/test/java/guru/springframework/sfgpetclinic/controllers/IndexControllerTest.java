package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

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
    }

    @Test
    void testAssumptionTrueFails() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("guru")));
    }
}