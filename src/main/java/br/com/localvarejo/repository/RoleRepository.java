package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.localvarejo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
