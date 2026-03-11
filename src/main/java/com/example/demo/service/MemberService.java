package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    public final MemberRepository memberRepository;

    public long join(String name,String email){
        Member member = new Member(name,email);
        return memberRepository.save(member).getId();
    }

    @Transactional(readOnly = true)
    public Member findById(long id){
        return memberRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Member not found" +id));
    }

    @Transactional(readOnly = true)
    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    @Transactional
    public Member update(Long id,String name,String email){
        Member member = memberRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Member not found"+id));

        member.update(name,email);
        return member;
    }

    public void delete(Long id){
        if(!memberRepository.existsById(id)){
            throw new IllegalArgumentException("Member not found"+id);
        }
        memberRepository.deleteById(id);
    }
}
