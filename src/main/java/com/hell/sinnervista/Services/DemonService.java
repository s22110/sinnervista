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
        return this.demonRepository.findDemonById(id);
    }

    public void deleteDemonById(Integer id){
        this.demonRepository.deleteById(id);
    }
}
