package com.hell.sinnervista;

import com.hell.sinnervista.Models.Demon;
import com.hell.sinnervista.Repositories.DemonRepository;
import com.hell.sinnervista.Repositories.SinnerRepository;
import com.hell.sinnervista.Services.DemonService;
import com.hell.sinnervista.Services.SinnerService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class DemonServiceIT {
    @Autowired
    private DemonService demonService;

    @MockBean
    private DemonRepository demonRepository;

    @Test
    void shouldGetAllDemons_NotEmpty() {
        Mockito.when(demonRepository.findAll())
                .thenReturn(List.of(new Demon()));

        List<Demon> demons = demonService.getAllDemons();

        assertFalse(demons.isEmpty());
    }

    @Test
    void shouldGetAllDemons_Empty() {
        Mockito.when(demonRepository.findAll())
                .thenReturn(List.of());

        List<Demon> demons = demonService.getAllDemons();

        assertTrue(demons.isEmpty());
    }

    @Test
    void shouldGetDemonById() {
        int id = 1;
        Mockito
                .when(demonRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(new Demon()));

        Demon demon = demonService.getDemonById(id);

        assertNotNull(demon);
    }

    @Test
    void createDemon() {
        Mockito
                .when(demonRepository.save(ArgumentMatchers.any()))
                .thenReturn(new Demon());

        Demon demon = demonService.createDemon("Doom");

        assertSame("Doom", demon.getName());
    }

    @Test
    void deleteDemonById() {
        int id = 1;
        final Demon demon = new Demon(1, "Bogdan");

        Optional<Demon> optionalDemon = Optional.of(demon);
        Mockito
                .when(demonRepository.findById(id))
                .thenReturn(optionalDemon);

        demonService.deleteDemonById(demon.getId());
        Mockito.verify(demonRepository, Mockito.times(1)).delete(demon);
    }
}
