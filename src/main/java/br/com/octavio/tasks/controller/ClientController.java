package br.com.octavio.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.octavio.tasks.entity.Client;
import br.com.octavio.tasks.services.ClientServices;


@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired 
	private ClientServices clientServices; 
	
	@PostMapping
	public ResponseEntity<Client> createTasks(@RequestBody Client client) {
		Client newClient = clientServices.createClient(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
}
	@GetMapping
	public ResponseEntity<List<Client>> listAllClient(){
		List<Client> allClient= clientServices.ListAllClient();
		return ResponseEntity.ok(allClient);}
		
	@GetMapping("/{id}")
	public ResponseEntity<?> searchClientById(@PathVariable Long id) {
		Client client = clientServices.searchClientById(id);
		if (client != null) {
			return ResponseEntity.ok(client);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("client not found");
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client UpdatedClient){
		Client client = clientServices.updateClient(id, UpdatedClient);
		if (client != null) {
			return ResponseEntity.ok(client);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found");
		}
		}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id){
		clientServices.deleteClient(id);
		return ResponseEntity.noContent().build();
	}
	}


