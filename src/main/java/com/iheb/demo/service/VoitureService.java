package com.iheb.demo.service;

import java.util.List;

import com.iheb.demo.entities.Marque;
import com.iheb.demo.entities.Voiture;

public interface VoitureService {
    Voiture saveVoiture(Voiture v);
    Voiture updateVoiture(Voiture v);
    void deleteVoiture(Voiture v);
    void deleteVoitureById(Long id);
    Voiture getVoiture(Long id);
    List<Voiture> getAllVoitures();
    List<Voiture> findByModeleVoiture(String modele);
    List<Voiture> findByModeleVoitureContains(String modele);
    List<Voiture> findByPrixVoiture(Double prix);
    List<Voiture> findByMarque(Marque marque);
    List<Voiture> findByMarqueIdMarque(Long id);
    List<Voiture> findByOrderByModeleVoitureAsc();
    List<Voiture> trierVoituresModelesPrix();
}
