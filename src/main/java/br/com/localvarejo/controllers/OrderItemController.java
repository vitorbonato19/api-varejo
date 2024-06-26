package br.com.localvarejo.controllers;

import br.com.localvarejo.controllers.dto.OrderItemDto;
import br.com.localvarejo.model.OrderItem;
import br.com.localvarejo.repository.OrderItemRepository;
import br.com.localvarejo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
public class OrderItemController {

    private final OrderItemRepository orderItemRepository;

    private final UserRepository userRepository;

    public OrderItemController(OrderItemRepository orderItemRepository, UserRepository userRepository) {
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/orderItems")
    public ResponseEntity<OrderItem> newOrderItem(@RequestBody OrderItemDto dto,
                                                  JwtAuthenticationToken token) {

        var user = userRepository.findById(UUID.fromString(token.getName()));

        var orderItem = new OrderItem();
        orderItem.setProduct(dto.product());
        orderItem.setOrder(dto.order());
        orderItem.setPrice(dto.price());
        orderItem.setQuantity(dto.quantity());

        orderItemRepository.save(orderItem);

        return ResponseEntity.ok().build();
    }


}
