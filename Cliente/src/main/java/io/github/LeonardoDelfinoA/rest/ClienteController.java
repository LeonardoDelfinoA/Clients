package io.github.LeonardoDelfinoA.rest;

import org.springframework.http.HttpStatus;
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

import io.github.LeonardoDelfinoA.model.Cliente;
import io.github.LeonardoDelfinoA.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	private final ClienteRepository repository;
	
	private ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente getById( @PathVariable Integer id ) {
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
	public void atualizar( @PathVariable Integer id, @RequestBody Cliente updatedClient ) {
		repository
		.findById(id)
		.map( client -> {
			updatedClient.setId(client.getId());
			return repository.save(updatedClient);
		})
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
}
