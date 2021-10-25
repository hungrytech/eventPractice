package com.event.eventpractice.member.presentation;

import com.event.eventpractice.common.utils.APiUtils;
import com.event.eventpractice.common.utils.ApiResponse;
import com.event.eventpractice.member.application.MemberJoinInfoDto;
import com.event.eventpractice.member.application.MemberResponseDto;
import com.event.eventpractice.member.application.MemberService;
import com.event.eventpractice.member.application.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/join")
    public ResponseEntity<ApiResponse<MemberResponseDto>> createMember(@RequestBody MemberJoinInfoDto joinInfoDto) {
        MemberResponseDto responseDto = memberService.join(joinInfoDto);
        return ResponseEntity.ok()
                .body(APiUtils.success(responseDto));
    }

    @PostMapping("{memberId}/order/new")
    public ResponseEntity<ApiResponse<Void>> createOrder(@RequestBody OrderRequestDto requestDto, @PathVariable Long memberId) {
        memberService.createOrder(memberId, requestDto);
        return ResponseEntity.ok()
                .body(APiUtils.success(null));
    }

}
