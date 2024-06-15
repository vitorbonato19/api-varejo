package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.localvarejo.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
