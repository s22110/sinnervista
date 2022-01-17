package com.hell.sinnervista.Services;

import com.hell.sinnervista.Models.Demon;
import com.hell.sinnervista.Repositories.DemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.demonRepository.getById(id);
    }

    public void createDemon(String name){
        Demon demon = new Demon(null, name);
        this.demonRepository.save(demon);
    }

    public void deleteDemonById(Integer id){
        this.demonRepository.deleteById(id);
    }

    public void createExampleDemons(){
        String[] demonNames = {"Azazel", "Baal", "Beelzebub", "Saael", "Asmodan", "Bob"};
        for(int i = 0; i <= 5; i++){
            createDemon(demonNames[i]);
        }
    }
}
