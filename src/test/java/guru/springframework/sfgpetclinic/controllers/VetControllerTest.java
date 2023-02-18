package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllersTest;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VetControllerTest implements ControllersTest {

    private VetController vetController;
    private VetService vetService;
    private SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "John", "Doe", null);
        Vet vet2 = new Vet(2L, "Jimmy", "Smith", null);
        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        // Given
        Model model = new ModelMapImpl();

        // When
        String view = vetController.listVets(model);

        // Then
        assertEquals("vets/index", view);
        Set vets = (Set) model.getMap().get("vets");
        assertEquals(2, vets.size());
    }
}