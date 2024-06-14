package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.localvarejo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
