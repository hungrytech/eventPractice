package com.event.eventpractice.member.event;

import lombok.Getter;

@Getter
public class MemberCreatedOrderEvent {
    private final Long memberId;
    private final String orderRequest;

    public MemberCreatedOrderEvent(Long memberId, String orderRequest) {
        this.memberId = memberId;
        this.orderRequest = orderRequest;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getOrderRequest() {
        return orderRequest;
    }
}
