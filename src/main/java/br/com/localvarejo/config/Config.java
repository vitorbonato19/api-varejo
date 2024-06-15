package br.com.localvarejo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.localvarejo.model.Client;
import br.com.localvarejo.repository.ClientRepository;
import br.com.localvarejo.repository.OrderItemRepository;
import br.com.localvarejo.repository.OrderRepository;
import br.com.localvarejo.repository.ProductRepository;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Client c1 = new Client(null, "Vitor", "vitor@java.com", "5244537858", "Real Parque");
		Client c2 = new Client(null, "Jose", "jose@java.com", "56485615646", "Paulinia");
		Client c3 = new Client(null, "Eduardo", "eduardo@java.com", "648791387", "Jundiai");
		Client c4 = new Client(null, "Alex", "alex@java.com", "0087870078", "Satelite Iris");
		Client c5 = new Client(null, "Carlos", "carlos@java.com", "99897350", "Swiss Park");
		
		clientRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		//Order o1 = new Order(null, "New Order!", Instant.parse("2024-03-25T11:05:33Z"), c1);
		
		
		
	}
}
