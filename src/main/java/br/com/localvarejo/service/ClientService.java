package br.com.localvarejo.service;

import br.com.localvarejo.model.Client;
import br.com.localvarejo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Optional<Client> findById(Long id){
		return repository.findById(id);
	}
	
	public Client insert(Client client) {
		return repository.save(client);
	}
	
	
}
