package com.iheb.demo.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.iheb.demo.entities.Marque;
import com.iheb.demo.entities.Voiture;

@RepositoryRestResource(path = "rest")
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    List<Voiture> findByModeleVoiture(String modele);
    List<Voiture> findByModeleVoitureContaining(String modele);
    
    @Query("select v from Voiture v where v.modeleVoiture like %:modele and v.prixVoiture > :prix")
    List<Voiture> findByModelePrix(@Param("modele") String modele, @Param("prix") Double prix);
    List<Voiture> findByMarque(Marque marque);
    List<Voiture> findByMarqueIdMarque(Long id);
    List<Voiture> findByOrderByModeleVoitureAsc();
    
    @Query("select v from Voiture v order by v.modeleVoiture ASC, v.prixVoiture DESC")
    List<Voiture> trierVoituresModelesPrix();

}
