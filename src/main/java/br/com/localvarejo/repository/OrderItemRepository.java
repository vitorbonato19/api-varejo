package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.localvarejo.model.OrderItem;
import br.com.localvarejo.model.embedd.OrderItemChild;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemChild>{

}
