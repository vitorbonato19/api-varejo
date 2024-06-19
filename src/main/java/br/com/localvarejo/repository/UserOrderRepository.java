package br.com.localvarejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.localvarejo.model.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long>{

}
