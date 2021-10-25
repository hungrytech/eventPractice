package com.event.eventpractice.order.event;

import com.event.eventpractice.member.event.MemberCreatedOrderEvent;
import com.event.eventpractice.order.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventHandler {
    private final OrderService orderService;

    @Async
    @EventListener
    public void createOrder(MemberCreatedOrderEvent event) {
        orderService.createOrder(event.getMemberId(), event.getOrderRequest());
    }

}
