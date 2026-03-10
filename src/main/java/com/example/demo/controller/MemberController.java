package com.example.demo.controller;


import com.example.demo.dto.CreateMemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public long create(@RequestBody CreateMemberRequest request){
        return memberService.join(request.name(), request.email());
    }

    @GetMapping("/members")
    public List<MemberResponse> list(){
        return memberService.findAll()
                .stream()
                .map(m->new MemberResponse(
                        m.getId(),
                        m.getName(),
                        m.getEmail(),
                        m.getCreatedAt()
                ))
                .toList();
    }

}
