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
import net.javaguides.springboot.model.LigneCommandeFournisseur;
import net.javaguides.springboot.repository.LigneCommandeFournisseurRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class LigneCommandeFournisseurController {
	@Autowired
	private LigneCommandeFournisseurRepository lcmdFournisseurRepository;
    // get all Fournisseur
	@GetMapping("/lignecmdfournisseur")
	public List<LigneCommandeFournisseur> getAlllCmdFournisseur(){
		return lcmdFournisseurRepository.findAll();
	}
	// (post) create
	@PostMapping("/lignecmdfournisseur/new")
	public LigneCommandeFournisseur createlignelcmdFournisseur(@RequestBody LigneCommandeFournisseur lcmdFournisseur) {
		return lcmdFournisseurRepository.save(lcmdFournisseur);
	}
	//get Fournisseurby id restapi
	@GetMapping("/lignecmdfournisseur/new1/{id}")
	public ResponseEntity<LigneCommandeFournisseur> getLigneCmdFournisseurById(@PathVariable Integer id) {
	 LigneCommandeFournisseur lcmdFournisseur = lcmdFournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fournisseur not exist with id :" + id));
		return ResponseEntity.ok(lcmdFournisseur);
	}
	//
	@PutMapping("/lignecmdfournisseur/{id}")
	public ResponseEntity<LigneCommandeFournisseur> updateLigneCmdFournisseur(@PathVariable Integer id, @RequestBody LigneCommandeFournisseur lignecmdFournisseurDetails){
		LigneCommandeFournisseur lcmdFournisseur = lcmdFournisseurRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not exist with id :" + id));
		
		lcmdFournisseur.setCreationDate(lignecmdFournisseurDetails.getCreationDate());
		lcmdFournisseur.setLastUpdateDate(lignecmdFournisseurDetails.getLastUpdateDate());
	
		LigneCommandeFournisseur updatedLigneCmdFournisseur =  lcmdFournisseurRepository.save(lcmdFournisseur);
		return ResponseEntity.ok(updatedLigneCmdFournisseur);
		
	}
	// delete lignecmdclient restAPI

	@DeleteMapping("/lignecmdfournisseur/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLigneCommandeFournisseur(@PathVariable Integer id){
			LigneCommandeFournisseur lcmdFournisseur = lcmdFournisseurRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("lcmdFournisseur not exist with id :" + id));
			lcmdFournisseurRepository.delete(lcmdFournisseur);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
}
}
