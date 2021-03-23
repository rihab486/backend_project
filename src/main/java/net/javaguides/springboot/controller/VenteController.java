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
import net.javaguides.springboot.model.Vente;
import net.javaguides.springboot.repository.VenteRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class VenteController {
	@Autowired
	private VenteRepository venteRepository;
    // get allVente
	@GetMapping("/vente")
	public List<Vente> getAllVente(){
		return venteRepository.findAll();
	}
	// (post) create
			@PostMapping("/vente/new")
			public Vente createVente(@RequestBody Vente u) {
				return venteRepository.save(u);
			}
			//get user by id restapi
			@GetMapping("/vente/new1/{id}")
			public ResponseEntity<Vente> getVenteById(@PathVariable Integer id) {
				Vente u = venteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vente not exist with id :" + id));
				return ResponseEntity.ok(u);
			}
			//
			@PutMapping("/vente/{id}")
			public ResponseEntity<Vente> updateVente(@PathVariable Integer id, @RequestBody Vente VenteDetails){
				Vente u = venteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Vente not exist with id :" + id));
				
				u.setCreationDate(VenteDetails.getCreationDate());
				u.setLastUpdateDate(VenteDetails.getLastUpdateDate());
				u.setCodev(VenteDetails.getCodev());
			
			
				Vente updatedVente = venteRepository.save(u);
				return ResponseEntity.ok(updatedVente);
			}
			// delete vente restAPI
			@DeleteMapping("/vente/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteVente(@PathVariable Integer id){
				Vente u = venteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Vente not exist with id :" + id));
				venteRepository.delete(u);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
	}
}
