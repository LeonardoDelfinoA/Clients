package io.github.LeonardoDelfinoA.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.LeonardoDelfinoA.model.Client;
import io.github.LeonardoDelfinoA.repositories.ClientRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

	private final ClientRepository repository;
	
	private ClientController(ClientRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(@RequestBody Client cliente) {
		return repository.save(cliente);
	}
	
	@GetMapping("/{id}")
	public Client getById( @PathVariable Integer id ) {
		return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable Integer id ) {
		repository
			.findById(id)
			.map( client -> {
				repository.delete(client);
				return Void.TYPE;
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar( @PathVariable Integer id, @RequestBody Client updatedClient ) {
		repository
		.findById(id)
		.map( client -> {
			updatedClient.setId(client.getId());
			return repository.save(updatedClient);
		})
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
}
