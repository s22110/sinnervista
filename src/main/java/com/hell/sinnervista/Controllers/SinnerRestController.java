package com.hell.sinnervista.Controllers;

import com.hell.sinnervista.Models.HellCircle;
import com.hell.sinnervista.Models.Sinner;
import com.hell.sinnervista.Services.SinnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinners")
public class SinnerRestController {
    private final SinnerService sinnerService;

    public SinnerRestController(SinnerService sinnerService) {
        this.sinnerService = sinnerService;

        sinnerService.createExampleSinners();
    }

    @GetMapping
    public ResponseEntity<List<Sinner>> getAllSinners(){
        List<Sinner> sinners = sinnerService.getAllSinners();
        return ResponseEntity.ok(sinners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sinner> getSinnerById(@PathVariable Integer id){
        Sinner sinner = sinnerService.getSinnerById(id);
        return ResponseEntity.ok(sinner);
    }

    @GetMapping("/circle/{hellCircle}")
    public ResponseEntity<List<Sinner>> getSinnersByHellCircle(@PathVariable HellCircle hellCircle){
        List<Sinner> sinnersInCircle = sinnerService.getSinnersByHellCircle(hellCircle);
        return ResponseEntity.ok(sinnersInCircle);
    }
}
