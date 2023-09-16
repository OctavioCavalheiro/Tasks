package br.com.octavio.tasks.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.octavio.tasks.entity.Client;
import br.com.octavio.tasks.repository.ClientRepository;

@Service
public class ClientServices{
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}
	
	public List<Client> ListAllClient(){
		return clientRepository.findAll();
	}
	
	public Client searchClientById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public Client updateClient(Long id, Client updatedClient) {
		Client existingClient = clientRepository.findById(id).orElse(null);
		if (existingClient != null) {
			existingClient.setName(updatedClient.getName());
			existingClient.setEmail(updatedClient.getEmail());
			existingClient.setCpf(updatedClient.getCpf());
			existingClient.setAdress(updatedClient.getAdress());
			return clientRepository.save(existingClient);
		}
		return null;
	}
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}
}
