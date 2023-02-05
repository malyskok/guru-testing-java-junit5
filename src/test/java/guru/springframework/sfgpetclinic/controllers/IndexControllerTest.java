package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    private IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "wrong index returned");
        assertEquals("index", controller.index(), () -> "wrong index returned" +
                "and now you see this" +
                "expensive long message");

    }

    @Test
    void oupsHandler() {
        assertEquals("notimplemented", controller.oupsHandler(), "wrong oups returned");
    }
}