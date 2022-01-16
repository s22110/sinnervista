package com.hell.sinnervista.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "demon")
public class Demon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sinner> sinners;

    public Demon() {
    }

    public Demon(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sinner> getSinners() {
        return sinners;
    }

    public void setSinners(List<Sinner> sinners) {
        this.sinners = sinners;
    }
}