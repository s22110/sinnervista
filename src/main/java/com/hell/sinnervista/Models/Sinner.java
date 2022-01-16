package com.hell.sinnervista.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sinner")
public class Sinner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Date joinDate;
    private HellCircle hellCircle;

    public Sinner(){
    }

    public Sinner(Integer id, String name, String surname, HellCircle hellCircle) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        setJoinDate();
        this.hellCircle = hellCircle;
    }

    public Sinner(Integer id, String name, String surname, Date joinDate, HellCircle hellCircle) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.joinDate = joinDate;
        this.hellCircle = hellCircle;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate() {
        this.joinDate = new Date();
    }

    public HellCircle getHellCircle() {
        return hellCircle;
    }

    public void setHellCircle(HellCircle hellCircle) {
        this.hellCircle = hellCircle;
    }
}
