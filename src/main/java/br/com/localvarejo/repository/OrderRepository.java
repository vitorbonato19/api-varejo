package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.localvarejo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
