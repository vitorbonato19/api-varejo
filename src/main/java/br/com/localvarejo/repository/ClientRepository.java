package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.localvarejo.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
