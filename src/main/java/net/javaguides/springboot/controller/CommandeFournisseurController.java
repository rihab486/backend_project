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
import net.javaguides.springboot.model.CommandeClient;
import net.javaguides.springboot.model.CommandeFournisseur;
import net.javaguides.springboot.repository.CommandeFournisseurRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class CommandeFournisseurController {
	@Autowired
	private CommandeFournisseurRepository cmdFournisseurRepository;
    // get all fournisseur
	@GetMapping("/cmdfournisseur")
	public List<CommandeFournisseur> getAllCmdFournisseur(){
		return cmdFournisseurRepository.findAll();
	}
	// (post) create
				@PostMapping("/cmdfournisseur/new")
				public CommandeFournisseur createcmdFournisseur(@RequestBody CommandeFournisseur cmdFournisseur) {
					return cmdFournisseurRepository.save(cmdFournisseur);
				}
		//get client by id restapi
			@GetMapping("/cmdfournisseur/new1/{id}")
				public ResponseEntity<CommandeFournisseur> getCmdFournisseurById(@PathVariable Integer id) {
				 CommandeFournisseur cmdFournisseur = cmdFournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CmdClient not exist with id :" + id));
					return ResponseEntity.ok(cmdFournisseur);
				}
			
			//
			@PutMapping("/cmdfournisseur/{id}")
			public ResponseEntity<CommandeFournisseur> updateCmdFournisseur(@PathVariable Integer id, @RequestBody CommandeFournisseur cmdFournisseurDetails){
				CommandeFournisseur cmdFournisseur = cmdFournisseurRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("CmdFournisseur not exist with id :" + id));
				
				cmdFournisseur.setCreationDate(cmdFournisseurDetails.getCreationDate());
				cmdFournisseur.setLastUpdateDate(cmdFournisseurDetails.getLastUpdateDate());
				cmdFournisseur.setCode(cmdFournisseurDetails. getCode());
				cmdFournisseur.setDatecommande(cmdFournisseurDetails.getDatecommande());
				CommandeFournisseur updatedCmdFournisseur =  cmdFournisseurRepository.save(cmdFournisseur);
				return ResponseEntity.ok(updatedCmdFournisseur);
				
			}
			// delete employee restAPI
			@DeleteMapping("/cmdfournisseur/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCmdFournisseur(@PathVariable Integer id){
				CommandeFournisseur cmdFournisseur = cmdFournisseurRepository.findById(id)	
						.orElseThrow(() -> new ResourceNotFoundException("CmdFournisseur not exist with id :" + id));
				 cmdFournisseurRepository.delete(cmdFournisseur);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
	}
}
