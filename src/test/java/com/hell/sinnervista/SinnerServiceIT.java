package com.hell.sinnervista;

import com.hell.sinnervista.Models.HellCircle;
import com.hell.sinnervista.Models.Sinner;
import com.hell.sinnervista.Repositories.SinnerRepository;
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
public class SinnerServiceIT {
    @Autowired
    private SinnerService sinnerService;

    @MockBean
    private SinnerRepository sinnerRepository;

    @Test
    void shouldFindAllSinners_NotEmpty() {
        Mockito.when(sinnerRepository.findAll())
                .thenReturn(List.of(new Sinner()));

        List<Sinner> sinners = sinnerService.getAllSinners();

        assertFalse(sinners.isEmpty());
    }

    @Test
    void shouldFindAllSinners_Empty() {
        Mockito.when(sinnerRepository.findAll())
                .thenReturn(List.of());

        List<Sinner> sinners = sinnerService.getAllSinners();

        assertTrue(sinners.isEmpty());
    }

    @Test
    void shouldFindSinnerById() {
        int id = 1;
        Mockito
                .when(sinnerRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(new Sinner()));

        Sinner sinner = sinnerService.getSinnerById(id);

        assertNotNull(sinner);
    }

    @Test
    void shouldGetSinnersByHellCircle_NotEmpty() {
        HellCircle hellCircle = HellCircle.JavaDevs;
        Mockito
                .when(sinnerRepository.findSinnersByHellCircle(ArgumentMatchers.any()))
                .thenReturn(List.of(new Sinner()));

        List<Sinner> sinners = sinnerService.getSinnersByHellCircle(hellCircle);

        assertFalse(sinners.isEmpty());
    }

    @Test
    void shouldGetSinnersByHellCircle_Empty() {
        HellCircle hellCircle = HellCircle.WellDoneSteakEaters;

        Mockito
                .when(sinnerRepository.findSinnersByHellCircle(ArgumentMatchers.any()))
                .thenReturn(List.of());

        List<Sinner> sinners = sinnerService.getSinnersByHellCircle(hellCircle);

        assertTrue(sinners.isEmpty());
    }

    @Test
    void shouldCreateSinner() {
        Mockito
                .when(sinnerRepository.save(ArgumentMatchers.any()))
                .thenReturn(new Sinner());

        Sinner sinner = sinnerService.createSinner("Doom", "Guy", HellCircle.Violence);

        assertSame("Doom", sinner.getName());
    }
}
