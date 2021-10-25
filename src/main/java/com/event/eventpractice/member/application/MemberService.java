package com.event.eventpractice.member.application;

import com.event.eventpractice.member.domain.Member;
import com.event.eventpractice.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public MemberResponseDto join(MemberJoinInfoDto joinInfoDto) {
        Member member = Member.createMember(joinInfoDto.getName(), joinInfoDto.getPhoneNumber());

        return MemberResponseDto.builder()
                .id(memberRepository.save(member).getId())
                .build();
    }

    @Transactional(readOnly = true)
    public void createOrder(Long id, OrderRequestDto orderRequestDto) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.createOrder(orderRequestDto.getOrderRequest(), publisher);
    }


}
