package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.localvarejo.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
