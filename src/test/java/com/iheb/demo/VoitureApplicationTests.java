package com.iheb.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iheb.demo.entities.Marque;
import com.iheb.demo.entities.Voiture;
import com.iheb.demo.repos.VoitureRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Date;
import java.util.List;

@SpringBootTest
class VoitureApplicationTests {

    @Autowired
    private VoitureRepository voitureRepository;

    @Test
    public void testCreateVoiture() {
        Voiture voiture = new Voiture("Ma Voiture", 25000.0, new Date());
        voitureRepository.save(voiture);
        
        // Vérifiez que la voiture a été créée
        Voiture savedVoiture = voitureRepository.findById(voiture.getIdVoiture()).orElse(null);
        assertNotNull(savedVoiture);
    }

    @Test
    public void testFindVoiture() {
        // Créez une voiture
        Voiture voiture = new Voiture("Ma Voiture", 25000.0, new Date());
        voitureRepository.save(voiture);
        
        // Recherchez la voiture par son ID
        Voiture foundVoiture = voitureRepository.findById(voiture.getIdVoiture()).orElse(null);
        assertNotNull(foundVoiture);
    }

    @Test
    public void testUpdateVoiture() {
        // Créez une voiture
        Voiture voiture = new Voiture("Ma Voiture", 25000.0, new Date());
        voitureRepository.save(voiture);
        
        // Mettez à jour le prix de la voiture
        double newPrice = 28000.0;
        voiture.setPrixVoiture(newPrice);
        voitureRepository.save(voiture);
        
        // Recherchez la voiture à nouveau pour vérifier la mise à jour
        Voiture updatedVoiture = voitureRepository.findById(voiture.getIdVoiture()).orElse(null);
        assertNotNull(updatedVoiture);
        assertEquals(newPrice, updatedVoiture.getPrixVoiture());
    }

    @Test
    public void testDeleteVoiture() {
        // Créez une voiture
        Voiture voiture = new Voiture("Ma Voiture", 25000.0, new Date());
        voitureRepository.save(voiture);
        
        // Supprimez la voiture
        voitureRepository.deleteById(voiture.getIdVoiture());
        
        // Essayez de rechercher la voiture supprimée
        Voiture deletedVoiture = voitureRepository.findById(voiture.getIdVoiture()).orElse(null);
        assertNull(deletedVoiture);
    }

    @Test
    public void testListerToutesLesVoitures() {
        // Créez quelques voitures
        Voiture voiture1 = new Voiture("Voiture 1", 30000.0, new Date());
        Voiture voiture2 = new Voiture("Voiture 2", 35000.0, new Date());
        voitureRepository.save(voiture1);
        voitureRepository.save(voiture2);
        
        // Liste de toutes les voitures
        List<Voiture> voitures = voitureRepository.findAll();
        assertNotNull(voitures);
        assertTrue(voitures.size() >= 2); // Vérifiez qu'il y a au moins 2 voitures
    }
    
    @Test
    public void testFindByModelePrix() {
        List<Voiture> voitures = voitureRepository.findByModelePrix("NomDuModele", 20000.0);
        for (Voiture v : voitures) {
            System.out.println(v);
        }
    }
    
    @Test
    public void testFindByMarque() {
        Marque marque = new Marque();
        marque.setIdMarque(1L); 
        List<Voiture> voitures = voitureRepository.findByMarque(marque);
        for (Voiture v : voitures) {
            System.out.println(v);
        }
    }
    
    @Test
    public void testFindByCategorieIdCat() {
        List<Voiture> voitures = voitureRepository.findByCategorieIdCat(1L); // Remplacez par l'ID de la catégorie
        for (Voiture v : voitures) {
            System.out.println(v);
        }
    }

    @Test
    public void testFindByOrderByModeleVoitureAsc() {
        List<Voiture> voitures = voitureRepository.findByOrderByModeleVoitureAsc();
        for (Voiture v : voitures) {
            System.out.println(v);
        }
    }

    @Test
    public void testTrierVoituresModelesPrix() {
        List<Voiture> voitures = voitureRepository.trierVoituresModelesPrix();
        for (Voiture v : voitures) {
            System.out.println(v);
        }
    }



}

