package com.hell.sinnervista.Controllers;

import com.hell.sinnervista.Models.Demon;
import com.hell.sinnervista.Services.DemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demons")
public class DemonRestController {
    private final DemonService demonService;

    public DemonRestController(DemonService demonService) {
        this.demonService = demonService;

        demonService.createExampleDemons();
    }

    @GetMapping
    public ResponseEntity<List<Demon>> getAllDemons(){
        List<Demon> demons = demonService.getAllDemons();
        return ResponseEntity.ok(demons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demon>getDemonById(@PathVariable Integer id){
        Demon demon = demonService.getDemonById(id);
        if (demon == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(demon);
    }

    @PostMapping("create/{name}")
    public ResponseEntity<String> createDemon(@PathVariable String name){
        demonService.createDemon(name);
        return ResponseEntity.ok("Created demon named: " + name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDemonById(@PathVariable Integer id){
        demonService.deleteDemonById(id);
        return ResponseEntity.ok("Deleted demon with id: " + id);
    }
}
