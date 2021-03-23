package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.LigneCommandeClient;
import net.javaguides.springboot.model.LigneVente;
import net.javaguides.springboot.repository.LigneVenteRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class LigneVenteController {
	@Autowired
	private LigneVenteRepository VenteRepository;
    // get all Vente
	@GetMapping("/lignevente")
	public List<LigneVente> getAllVente(){
		return VenteRepository.findAll();
	}
	        // (post) create
				@PostMapping("/lignevente/new")
				public LigneVente createligneVente(@RequestBody LigneVente Vente) {
					return VenteRepository.save(Vente);
				}
				//get vente by id restapi
				@GetMapping("/lignevente/new1/{id}")
				public ResponseEntity<LigneVente> getLigneVenteById(@PathVariable Integer id) {
				 LigneVente Vente = VenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ligneCmdClient not exist with id :" + id));
					return ResponseEntity.ok(Vente);
				}
				//
				@PutMapping("/lignevente/{id}")
				public ResponseEntity<LigneVente> updateLigneVente(@PathVariable Integer id, @RequestBody LigneVente VenteDetails){
					LigneVente Vente = VenteRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Vente not exist with id :" + id));
					
					Vente.setCreationDate(VenteDetails.getCreationDate());
					Vente.setLastUpdateDate(VenteDetails.getLastUpdateDate());
				
					LigneVente updatedLigneVente =  VenteRepository.save(Vente);
					return ResponseEntity.ok(updatedLigneVente);
					
				}
				// delete lignevente restAPI
				
				@DeleteMapping("/lignevente/{id}")
				public ResponseEntity<Map<String, Boolean>> deleteVente(@PathVariable Integer id){
						LigneVente Vente= VenteRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Vente not exist with id :" + id));
						VenteRepository.delete(Vente);
						Map<String, Boolean> response = new HashMap<>();
						response.put("deleted", Boolean.TRUE);
						return ResponseEntity.ok(response);
			}
}
