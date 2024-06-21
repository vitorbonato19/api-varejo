package br.com.localvarejo.controllers.dto;

import br.com.localvarejo.model.Order;
import br.com.localvarejo.model.Product;

public record OrderItemDto(Product product, Order order, Integer quantity, Double price) {
}
