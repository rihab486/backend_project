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
import net.javaguides.springboot.model.Entreprise;
import net.javaguides.springboot.repository.EntrepriseRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class EntrepriseController {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
    // get all Entreprise
	@GetMapping("/entreprise")
	public List<Entreprise> getAllEntreprise(){
		return entrepriseRepository.findAll();
	}
	// (post) create
		@PostMapping("/entreprise/new")
		public Entreprise createEntreprise(@RequestBody Entreprise e) {
			return entrepriseRepository.save(e);
		}
		//get Entreprise by id restapi
		@GetMapping("/entreprise/new1/{id}")
		public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Integer id) {
			Entreprise e = entrepriseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entreprise not exist with id :" + id));
			return ResponseEntity.ok(e);
		}
		//
		@PutMapping("/entreprise/{id}")
		public ResponseEntity<Entreprise> updateEntreprise(@PathVariable Integer id, @RequestBody Entreprise EntrepriseDetails){
			Entreprise e = entrepriseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entreprise not exist with id :" + id));
			
			e.setCreationDate(EntrepriseDetails.getCreationDate());
			e.setLastUpdateDate(EntrepriseDetails.getLastUpdateDate());
		
			Entreprise updatedEntreprise = entrepriseRepository.save(e);
			return ResponseEntity.ok(updatedEntreprise);
		}
		
		// delete Entreprise restAPI
				@DeleteMapping("/entreprise/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Integer id){
					Entreprise e = entrepriseRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Entreprise not exist with id :" + id));
					entrepriseRepository.delete(e);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
		}

}
