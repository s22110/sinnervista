package com.hell.sinnervista.Services;

import com.hell.sinnervista.Models.HellCircle;
import com.hell.sinnervista.Models.Sinner;
import com.hell.sinnervista.Repositories.SinnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinnerService {
    private final SinnerRepository sinnerRepository;

    public SinnerService(SinnerRepository sinnerRepository) {
        this.sinnerRepository = sinnerRepository;
    }

    public List<Sinner> getAllSinners(){
        return sinnerRepository.findAll();
    }

    public Sinner getSinnerById(Integer id){
        Optional<Sinner> sinner = sinnerRepository.findById(id);
        return sinner.orElse(null);
    }

    public List<Sinner> getSinnersByHellCircle(HellCircle hellCircle){
        return sinnerRepository.findSinnersByHellCircle(hellCircle);
    }

    public Sinner createSinner(String name, String surname, HellCircle hellCircle){
        Sinner sinner = new Sinner(null, name, surname, hellCircle);
        sinnerRepository.save(sinner);

        return sinner;
    }

    public void createExampleSinners(){
        Sinner[] sinners = {new Sinner(null, "Adam", "Słodowy", HellCircle.Limbo),
                new Sinner(null, "Adam", "Słodowy", HellCircle.Limbo),
                new Sinner(null, "Michał", "Wiśniewski", HellCircle.WellDoneSteakEaters),
                new Sinner(null, "Jabba", "Hutt", HellCircle.Gluttony),
                new Sinner(null, "James", "Gosling", HellCircle.JavaDevs),
                new Sinner(null, "Maciej", "K", HellCircle.WellDoneSteakEaters),
                new Sinner(null, "Anakin", "Skywalker", HellCircle.WrathAndSullenness),
                new Sinner(null, "Rey", "Skywalker", HellCircle.Heresy)
        };

        for (var sinner: sinners){
            createSinner(sinner.getName(), sinner.getSurname(), sinner.getHellCircle());
        }
    }
}
