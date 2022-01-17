package com.hell.sinnervista.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hell.sinnervista.Models.Demon;

import java.util.List;


@Repository
public interface DemonRepository extends JpaRepository<Demon, Integer> {
}
