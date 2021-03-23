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
import net.javaguides.springboot.model.Client;
import net.javaguides.springboot.model.Fournisseur;
import net.javaguides.springboot.repository.FournisseurRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class FournisseurController {
	@Autowired
	private FournisseurRepository fournisseurRepository;
    // get all employees
	@GetMapping("/fournisseur")
	public List<Fournisseur> getAllFournisseur(){
		return fournisseurRepository.findAll();
	}
	// (post) create
			@PostMapping("/fournisseur/new")
			public Fournisseur createFournisseur(@RequestBody Fournisseur f) {
				return fournisseurRepository.save(f);
	}
			//get client by id restapi
			@GetMapping("/fournisseur/new1/{id}")
			public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Integer id) {
				Fournisseur f = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));
				return ResponseEntity.ok(f);
			}
			//
			@PutMapping("/fournisseur/{id}")
			public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Integer id, @RequestBody Fournisseur FournisseurDetails){
				Fournisseur f = fournisseurRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not exist with id :" + id));
				
			f.setCreationDate(FournisseurDetails.getCreationDate());
				f.setLastUpdateDate(FournisseurDetails.getLastUpdateDate());
				f.setNom(FournisseurDetails.getNom());
				f.setPrenom(FournisseurDetails.getPrenom());
				f.setAdresse(FournisseurDetails.getAdresse());
				f.setNumTel(FournisseurDetails.getNumTel());
				f.setMail(FournisseurDetails.getMail());
				f.setPassword(FournisseurDetails.getPassword());
				Fournisseur updatedFournisseur = fournisseurRepository.save(f);
				return ResponseEntity.ok(updatedFournisseur);
			}
			// delete fournisseur restAPI
			@DeleteMapping("/fournisseur/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteFournisseur(@PathVariable Integer id){
				Fournisseur f = fournisseurRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("fournisseur not exist with id :" + id));
				fournisseurRepository.delete(f);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
	}
}
