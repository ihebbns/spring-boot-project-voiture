package com.iheb.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iheb.demo.entities.Marque;
import com.iheb.demo.entities.Voiture;
import com.iheb.demo.repos.VoitureRepository;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public Voiture saveVoiture(Voiture v) {
        return voitureRepository.save(v);
    }

    @Override
    public Voiture updateVoiture(Voiture v) {
        return voitureRepository.save(v);
    }

    @Override
    public void deleteVoiture(Voiture v) {
        voitureRepository.delete(v);
    }

    @Override
    public void deleteVoitureById(Long id) {
        voitureRepository.deleteById(id);
    }

    @Override
    public Voiture getVoiture(Long id) {
        return voitureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }
    
    @Override
    public List<Voiture> findByModeleVoiture(String modele) {
        return voitureRepository.findByModeleVoiture(modele);
    }

	@Override
	public List<Voiture> findByModeleVoitureContains(String modele) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voiture> findByPrixVoiture(Double prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voiture> findByMarque(Marque marque) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voiture> findByMarqueIdMarque(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voiture> findByOrderByModeleVoitureAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voiture> trierVoituresModelesPrix() {
		// TODO Auto-generated method stub
		return null;
	}

}
