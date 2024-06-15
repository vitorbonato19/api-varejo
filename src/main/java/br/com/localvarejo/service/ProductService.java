package br.com.localvarejo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.localvarejo.model.Product;
import br.com.localvarejo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}
	
}
