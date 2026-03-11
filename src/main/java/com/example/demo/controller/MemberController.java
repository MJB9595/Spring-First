package com.example.demo.controller;


import com.example.demo.dto.CreateMemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.dto.UpdateMemberRequest;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/members/{id}")
    public MemberResponse findOne(@PathVariable long id){
        var m = memberService.findById(id);

        return new MemberResponse(
                m.getId(),
                m.getName(),
                m.getEmail(),
                m.getCreatedAt()
        );
    }

    @PatchMapping("/members/{id}")
    public MemberResponse update(@PathVariable long id,
                                 @RequestBody UpdateMemberRequest request){
        var updatedMember = memberService.update(id,request.name(),request.email());

        return new MemberResponse(
                updatedMember.getId(),
                updatedMember.getName(),
                updatedMember.getEmail(),
                updatedMember.getCreatedAt()
        );
    }

    @DeleteMapping("/members/{id}")
    public void delete(@PathVariable long id){
        memberService.delete(id);
    }

}
