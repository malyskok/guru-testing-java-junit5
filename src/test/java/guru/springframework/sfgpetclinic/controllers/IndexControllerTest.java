package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}