package com.iheb.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoiture;
    private String modeleVoiture;
    private Double prixVoiture;
    private Date dateAchat;

    @ManyToOne
    private Marque marque; // Ajout de la relation avec la marque
    
    public Voiture() {
    }

    public Voiture(String modeleVoiture, Double prixVoiture, Date dateAchat) {
        this.modeleVoiture = modeleVoiture;
        this.prixVoiture = prixVoiture;
        this.dateAchat = dateAchat;
    }

    public Long getIdVoiture() {
        return idVoiture;
    }
    
    

    public void setIdVoiture(Long idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getModeleVoiture() {
        return modeleVoiture;
    }

    public void setModeleVoiture(String modeleVoiture) {
        this.modeleVoiture = modeleVoiture;
    }

    public Double getPrixVoiture() {
        return prixVoiture;
    }

    public void setPrixVoiture(Double prixVoiture) {
        this.prixVoiture = prixVoiture;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }
}

