package br.com.localvarejo.service;

import java.util.List;
import java.util.Optional;

import br.com.localvarejo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.localvarejo.model.Order;
import br.com.localvarejo.repository.OrderRepository;

@Service
public class OrderService {


	private final OrderRepository repository;

	private final OrderItemRepository oderItemRepository;

	public OrderService(OrderRepository repository, OrderItemRepository oderItemRepository) {
		this.repository = repository;
		this.oderItemRepository = oderItemRepository;
	}




	public List<Order> findAll() { 
		return repository.findAll();
	}
	
	public Optional<Order> findById(Long id) {
		return repository.findById(id);
	}
	
	public Order insert(Order order) {
		return repository.save(order);
	}
}
