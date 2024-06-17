package br.com.localvarejo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.localvarejo.model.Client;
import br.com.localvarejo.model.Order;
import br.com.localvarejo.model.OrderItem;
import br.com.localvarejo.model.Payment;
import br.com.localvarejo.model.enums.OrderStatusEnum;
import br.com.localvarejo.repository.ClientRepository;
import br.com.localvarejo.repository.OrderItemRepository;
import br.com.localvarejo.repository.OrderRepository;
import br.com.localvarejo.repository.PaymentRepository;
import br.com.localvarejo.repository.ProductRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Client c1 = new Client(null, "Vitor", "vitor@java.com", "897891644", "Real Parque");
		Client c2 = new Client(null, "Jose", "jose@java.com", "56485615646", "Paulinia");
		Client c3 = new Client(null, "Eduardo", "eduardo@java.com", "648791387", "Jundiai");
		Client c4 = new Client(null, "Alex", "alex@java.com", "0087870078", "Satelite Iris");
		Client c5 = new Client(null, "Carlos", "carlos@java.com", "99897350", "Swiss Park");
		
		clientRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		Order o1 = new Order(null, "Thank you for buy our product! Hope full you enjoy...", Instant.parse("2024-06-26T22:43:55Z"), OrderStatusEnum.PAYD, c1);
		Order o2 = new Order(null, "Thank you for buy our product! Hope full you enjoy...", Instant.parse("2024-06-16T17:32:14Z"), OrderStatusEnum.CANCELED, c2);
		Order o3 = new Order(null, "Thank you for buy our product! Hope full you enjoy...", Instant.parse("2024-06-16T17:33:26Z"), OrderStatusEnum.PAYD, c2);
		Order o4 = new Order(null, "Thank you for buy our product! Hope full you enjoy...", Instant.parse("2024-06-10T16:20:43Z"), OrderStatusEnum.DELIVERED, c3);
		Order o5 = new Order(null, "Thank you for buy our product! Hope full you enjoy...", Instant.parse("2024-06-09T21:15:15Z"), OrderStatusEnum.PAYD, c4);
		Order o6 = new Order(null, "Thank you for buy our product! Hope full you enjoy...", Instant.parse("2024-06-05T19:06:01Z"), OrderStatusEnum.DELIVERED, c5);
		
		Payment p1 = new Payment(null, Instant.parse("2024-06-26T22:43:55Z"), o1);
		Payment p2 = new Payment(null, Instant.parse("2024-06-16T17:32:14Z"), o2);
		Payment p3 = new Payment(null, Instant.parse("2024-06-16T17:33:26Z"), o3);
		Payment p4 = new Payment(null, Instant.parse("2024-06-10T16:20:43Z"), o4);
		Payment p5 = new Payment(null, Instant.parse("2024-06-09T21:15:15Z"), o5);
		Payment p6 = new Payment(null, Instant.parse("2024-06-05T19:06:01Z"), o6);
		
		
		paymentRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6));
		
	}
}
