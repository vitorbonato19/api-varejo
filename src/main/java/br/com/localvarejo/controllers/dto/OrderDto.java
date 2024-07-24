package br.com.localvarejo.controllers.dto;

import br.com.localvarejo.model.OrderItem;
import br.com.localvarejo.model.User;

import java.util.Set;

public class OrderDto {

    private final User user;

    private final Set<OrderItem> orderItem;

    public OrderDto(User user, Set<OrderItem> orderItem) {
        this.user = user;
        this.orderItem = orderItem;
    }
}
