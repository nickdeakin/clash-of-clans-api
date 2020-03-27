package com.nickdeakin.clashofclansservice.controllers;

import com.nickdeakin.clashofclansservice.domain.Member;
import com.nickdeakin.clashofclansservice.domain.dto.MemberDTO;
import com.nickdeakin.clashofclansservice.exceptions.MemberNotFoundException;
import com.nickdeakin.clashofclansservice.exceptions.ResourceIdURIBodyMismatchException;
import com.nickdeakin.clashofclansservice.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(MemberController.BASE_URL)
public class MemberController {
    static final String BASE_URL = "/members";

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> listMembers() {
        return memberService.listMembers();
    }

    @GetMapping("/{memberId:.+}")
    public Member getMember(@PathVariable String memberId) throws MemberNotFoundException {
        return memberService.getMemberById(memberId);
    }

    @PostMapping
    public Member createMember(@RequestBody MemberDTO memberDTO) {
        return memberService.createMember(Member.fromDto(memberDTO));
    }

    @PutMapping("/{memberId:.+}")
    public Member updateMember(@PathVariable String memberId,
                               @RequestBody MemberDTO memberDTO) throws MemberNotFoundException, ResourceIdURIBodyMismatchException {
        return memberService.updateMemberById(memberId, Member.fromDto(memberDTO));
    }

    @DeleteMapping("/{memberId:.+}")
    public void deleteMember(@PathVariable String memberId) {
        memberService.deleteMemberById(memberId);
    }
}
