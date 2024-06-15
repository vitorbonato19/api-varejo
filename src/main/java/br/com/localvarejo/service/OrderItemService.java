package br.com.localvarejo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.localvarejo.model.OrderItem;
import br.com.localvarejo.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	public List<OrderItem> findAll() {
		return repository.findAll();
	}
	
	public Optional<OrderItem> findById(Long id) {
		return repository.findById(id);
	}
	
}
