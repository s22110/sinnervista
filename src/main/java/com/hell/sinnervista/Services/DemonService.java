package com.hell.sinnervista.Services;

import com.hell.sinnervista.Models.Demon;
import com.hell.sinnervista.Models.Sinner;
import com.hell.sinnervista.Repositories.DemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemonService {

    private final DemonRepository demonRepository;

    public DemonService(DemonRepository demonRepository) {
        this.demonRepository = demonRepository;
    }

    public List<Demon> getAllDemons(){
        return this.demonRepository.findAll();
    }

    public Demon getDemonById(Integer id){
        Optional<Demon> demon = demonRepository.findById(id);

        return demon.orElse(null);
    }

    public Demon createDemon(String name){
        Demon demon = new Demon(null, name);
        this.demonRepository.save(demon);

        return demon;
    }

    public void deleteDemonById(Integer id){
        var demon = getDemonById(id);

        if (demon != null){
            this.demonRepository.delete(demon);
        }
    }

    public void createExampleDemons(){
        String[] demonNames = {"Azazel", "Baal", "Beelzebub", "Saael", "Asmodan", "Bob"};
        for(int i = 0; i <= 5; i++){
            createDemon(demonNames[i]);
        }
    }
}
