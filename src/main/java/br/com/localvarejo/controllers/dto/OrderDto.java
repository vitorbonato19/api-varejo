package br.com.localvarejo.controllers.dto;

import br.com.localvarejo.model.OrderItem;
import br.com.localvarejo.model.User;

import java.util.Set;

public record OrderDto(Set<OrderItem> items, User user) {
}
