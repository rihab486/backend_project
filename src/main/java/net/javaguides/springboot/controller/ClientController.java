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
import net.javaguides.springboot.repository.ClientRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
	@Autowired
	private ClientRepository ClientRepository;
    // get all employees
	@GetMapping("/client")
	public List<Client> getAllEmployees(){
		return ClientRepository.findAll();
	}
	// (post) create
		@PostMapping("/client/new")
		public Client createClient(@RequestBody Client client) {
			return ClientRepository.save(client);
		}
		//get client by id restapi
		@GetMapping("/client/new1/{id}")
		public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
		 Client client = ClientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));
			return ResponseEntity.ok(client);
		}
		//
		@PutMapping("/client/{id}")
		public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody Client clientDetails){
			Client client = ClientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));
			
			client.setCreationDate(clientDetails.getCreationDate());
			client.setLastUpdateDate(clientDetails.getLastUpdateDate());
			client.setNom(clientDetails.getNom());
			client.setPrenom(clientDetails.getPrenom());
			client.setAdresse(clientDetails.getAdresse());
			client.setNumTel(clientDetails.getNumTel());
			client.setMail(clientDetails.getMail());
			client.setPassword(clientDetails.getPassword());
			Client updatedClient = ClientRepository.save(client);
			return ResponseEntity.ok(updatedClient);
		}
		// delete client restAPI
				@DeleteMapping("/client/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Integer id){
					Client client = ClientRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Complet not exist with id :" + id));
					ClientRepository.delete(client);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
		}
		}
