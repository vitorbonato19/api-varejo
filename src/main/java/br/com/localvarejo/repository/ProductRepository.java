package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.localvarejo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
