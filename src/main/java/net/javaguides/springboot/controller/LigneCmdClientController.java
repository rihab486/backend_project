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
import net.javaguides.springboot.repository.LigneCommandeClientRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class LigneCmdClientController {
	@Autowired
	private LigneCommandeClientRepository lcmdclientRepository;
    // get all employees
	@GetMapping("/lignecmdclient")
	public List<LigneCommandeClient> getAllCmdClient(){
		return lcmdclientRepository.findAll();
	}
	// (post) create
				@PostMapping("/lignecmdclient/new")
				public LigneCommandeClient createlignecmdClient(@RequestBody LigneCommandeClient lcmdclient) {
					return lcmdclientRepository.save(lcmdclient);
				}
				//get client by id restapi
				@GetMapping("/lignecmdclient/new1/{id}")
				public ResponseEntity<LigneCommandeClient> getLigneCmdClientById(@PathVariable Integer id) {
				 LigneCommandeClient lcmdclient = lcmdclientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ligneCmdClient not exist with id :" + id));
					return ResponseEntity.ok(lcmdclient );
				}
				//
				@PutMapping("/lignecmdclient/{id}")
				public ResponseEntity<LigneCommandeClient> updateLigneCmdClient(@PathVariable Integer id, @RequestBody LigneCommandeClient lignecmdclientDetails){
					LigneCommandeClient lcmdclient = lcmdclientRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("CmdClient not exist with id :" + id));
					
					lcmdclient.setCreationDate(lignecmdclientDetails.getCreationDate());
					lcmdclient.setLastUpdateDate(lignecmdclientDetails.getLastUpdateDate());
				
					LigneCommandeClient updatedLigneCmdClient =  lcmdclientRepository.save(lcmdclient);
					return ResponseEntity.ok(updatedLigneCmdClient);
					
				}
				// delete lignecmdclient restAPI
			
				@DeleteMapping("/lignecmdclient/{id}")
				public ResponseEntity<Map<String, Boolean>> deleteLigneCommandeClient(@PathVariable Integer id){
						LigneCommandeClient lcmdclient = lcmdclientRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("lcmdclient not exist with id :" + id));
						lcmdclientRepository.delete(lcmdclient);
						Map<String, Boolean> response = new HashMap<>();
						response.put("deleted", Boolean.TRUE);
						return ResponseEntity.ok(response);
			}
}
