package com.event.eventpractice.member.domain;

import com.event.eventpractice.common.BaseTimeEntity;
import com.event.eventpractice.member.event.MemberCreatedOrderEvent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private Member(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static Member createMember(String name, String phoneNumber) {
        return new Member(name, phoneNumber);
    }

    public void createOrder(String orderRequest, ApplicationEventPublisher publisher) {
        publisher.publishEvent(new MemberCreatedOrderEvent(this.id, orderRequest));
    }
}
