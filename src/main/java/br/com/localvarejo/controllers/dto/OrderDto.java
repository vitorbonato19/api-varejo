package br.com.localvarejo.controllers.dto;

import br.com.localvarejo.model.OrderItem;

import java.util.Set;

public record OrderDto(Set<OrderItem> items) {
}
