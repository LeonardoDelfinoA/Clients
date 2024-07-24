package io.github.LeonardoDelfinoA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.LeonardoDelfinoA.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
