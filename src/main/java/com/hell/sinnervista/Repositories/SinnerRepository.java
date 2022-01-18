package com.hell.sinnervista.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.hell.sinnervista.Models.HellCircle;
import com.hell.sinnervista.Models.Sinner;

@Repository
public interface SinnerRepository extends JpaRepository<Sinner, Integer>{
    public List<Sinner> findSinnersByHellCircle(HellCircle hellCircle);
}
