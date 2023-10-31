package com.iheb.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarque;
    private String nomMarque;
    
    @JsonIgnore
    @OneToMany(mappedBy = "marque")
    private List<Voiture> voitures;

    public Marque() {
    }

    public Marque(String nomMarque, List<Voiture> voitures) {
        this.nomMarque = nomMarque;
        this.voitures = voitures;
    }

    public Long getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Long idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }
}
