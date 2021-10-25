package com.event.eventpractice.order.application;

import com.event.eventpractice.order.domain.Order;
import com.event.eventpractice.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public void createOrder(Long memberId, String orderRequest) {
        Order order = Order.createOrder(memberId, orderRequest);
        orderRepository.save(order);
    }
}
