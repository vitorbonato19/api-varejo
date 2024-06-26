package br.com.localvarejo.controllers;

import br.com.localvarejo.controllers.dto.OrderDto;
import br.com.localvarejo.controllers.dto.OrderItemDto;
import br.com.localvarejo.model.Order;
import br.com.localvarejo.model.enums.OrderStatusEnum;
import br.com.localvarejo.repository.OrderRepository;
import br.com.localvarejo.repository.UserRepository;
import br.com.localvarejo.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class OrderController {


	private final OrderService service;

	private final OrderRepository orderRepository;

	private final UserRepository userRepository;

	private final RestTemplate restTemplate;

	@Value("${OrderItemController.url}")
	private String orderItemUrl;

	public OrderController(OrderService service, OrderRepository repository, OrderRepository orderRepository, UserRepository userRepository, RestTemplate restTemplate) {
		this.service = service;
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
		this.restTemplate = restTemplate;
	}

	@GetMapping("/orders")
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/orders/{id}")
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	public ResponseEntity<Optional<Order>> findById(@PathVariable Long id) {
		Optional<Order> list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}

	@Transactional
	@PostMapping("/orders")
	public ResponseEntity<String> newOrder(@RequestBody OrderDto dto) {

		var newOrder = new Order();
		newOrder.setItems(dto.items());
		newOrder.setOrderStatusEnum(OrderStatusEnum.PAYD);
		newOrder.setUser(dto.user());
		newOrder.setDesc("Thank you for buy our products!");

		String url = orderItemUrl;

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
			return ResponseEntity.ok("Order created. Response from OrderItems" + response.getBody());
		} catch (RestClientException ex) {
			return ResponseEntity.status(500).body("Error calling OrderItemsController : " + ex.getMessage());
		}

	}


}
