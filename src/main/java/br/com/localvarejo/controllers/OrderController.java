package br.com.localvarejo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.com.localvarejo.controllers.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.localvarejo.model.Order;
import br.com.localvarejo.service.OrderService;

@RestController
@RequestMapping
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Order>> findById(@PathVariable Long id) {
		Optional<Order> list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Order> newOrder(@RequestBody OrderItemDto dto) {

		var newOrder =

	}


}
