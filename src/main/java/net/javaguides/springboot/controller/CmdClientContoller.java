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
import net.javaguides.springboot.repository.CommandeClientRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class CmdClientContoller {
	@Autowired
	private CommandeClientRepository cmdclientRepository;
    // get all employees
	@GetMapping("/cmdclient")
	public List<CommandeClient> getAllCmdClient(){
		return cmdclientRepository.findAll();
	}
	// (post) create
			@PostMapping("/cmdclient/new")
			public CommandeClient createcmdClient(@RequestBody CommandeClient cmdclient) {
				return cmdclientRepository.save(cmdclient);
			}
			//get client by id restapi
			@GetMapping("/cmdclient/new1/{id}")
			public ResponseEntity<CommandeClient> getCmdClientById(@PathVariable Integer id) {
			 CommandeClient cmdclient = cmdclientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CmdClient not exist with id :" + id));
				return ResponseEntity.ok(cmdclient );
			}
			
			//
			@PutMapping("/cmdclient/{id}")
			public ResponseEntity<CommandeClient> updateCmdClient(@PathVariable Integer id, @RequestBody CommandeClient cmdclientDetails){
				CommandeClient cmdclient = cmdclientRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("CmdClient not exist with id :" + id));
				
				cmdclient.setCreationDate(cmdclientDetails.getCreationDate());
				cmdclient.setLastUpdateDate(cmdclientDetails.getLastUpdateDate());
				cmdclient.setCode(cmdclientDetails. getCode());
				cmdclient.setDatecommande(cmdclientDetails.getDatecommande());
				CommandeClient updatedCmdClient =  cmdclientRepository.save(cmdclient);
				return ResponseEntity.ok(updatedCmdClient);
				
			}
			// delete employee restAPI
			@DeleteMapping("/cmdclient/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCmdClient(@PathVariable Integer id){
				CommandeClient cmdclient = cmdclientRepository.findById(id)	
						.orElseThrow(() -> new ResourceNotFoundException("Cmdclient not exist with id :" + id));
				 cmdclientRepository.delete(cmdclient);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
	}
}

