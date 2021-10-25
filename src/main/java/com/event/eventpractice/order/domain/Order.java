package com.event.eventpractice.order.domain;

import com.event.eventpractice.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Orders")
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderRequest;

    @Column(name = "member_id")
    private Long memberId;

    private Order(String orderRequest, Long memberId) {
        this.orderRequest = orderRequest;
        this.memberId = memberId;
    }

    public static Order createOrder(Long memberId, String orderRequest) {
        return new Order(orderRequest, memberId);
    }
}
