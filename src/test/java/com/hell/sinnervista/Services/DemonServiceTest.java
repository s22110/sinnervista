package com.hell.sinnervista.Services;

import com.hell.sinnervista.Models.Demon;
import com.hell.sinnervista.Models.HellCircle;
import com.hell.sinnervista.Models.Sinner;
import com.hell.sinnervista.Repositories.DemonRepository;
import com.hell.sinnervista.Repositories.SinnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DemonServiceTest {

    @Mock
    private DemonRepository demonRepository;

    @InjectMocks
    private DemonService demonService;

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