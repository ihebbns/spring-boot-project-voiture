package com.iheb.demo.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.iheb.demo.entities.Voiture;
import com.iheb.demo.service.VoitureService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
@Autowired
VoitureService produitService;
@RequestMapping(method = RequestMethod.GET)
public List<Voiture> getAllProduits() {
return produitService.getAllVoitures();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Voiture getProduitById(@PathVariable("id") Long id) {
return produitService.getVoiture(id);
 }

@RequestMapping(method = RequestMethod.POST)
public Voiture createProduit(@RequestBody Voiture produit) {
return produitService.saveVoiture(produit);
}

@RequestMapping(method = RequestMethod.PUT)
public Voiture updateProduit(@RequestBody Voiture produit) {
return produitService.updateVoiture(produit);
}

@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteProduit(@PathVariable("id") Long id)
{
produitService.deleteVoitureById(id);
}

@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
public List<Voiture> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
return produitService.findByMarqueIdMarque(idCat);
}




}
