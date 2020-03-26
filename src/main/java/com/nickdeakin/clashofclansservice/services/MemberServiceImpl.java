package com.nickdeakin.clashofclansservice.services;

import com.nickdeakin.clashofclansservice.domain.Member;
import com.nickdeakin.clashofclansservice.exceptions.MemberNotFoundException;
import com.nickdeakin.clashofclansservice.exceptions.ResourceIdURIBodyMismatchException;
import com.nickdeakin.clashofclansservice.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public List<Member> listMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    @Transactional
    public Member getMemberById(String memberId) throws MemberNotFoundException {
        Optional<Member> memberOptional = memberRepository.findById(memberId);

        if(!memberOptional.isPresent()) {
            throw new MemberNotFoundException(
                    String.format("%s is not an identifier for any current member resource", memberId));
        }
        return memberOptional.get();
    }

    @Override
    public Member updateMemberById(String memberId, Member member) throws ResourceIdURIBodyMismatchException, MemberNotFoundException {
        Optional<Member> memberOptional = memberRepository.findById(memberId);

        if(!Objects.equals(memberId, member.getId())) {
            throw new ResourceIdURIBodyMismatchException(
                    (String.format("%s does not match %s in the body", memberId, member.getId())));
        }

        if(!memberOptional.isPresent()) {
            throw new MemberNotFoundException(
                    String.format("%s is not an identifier for any current member resource", memberId));
        }
        return memberRepository.save(member);
    }

    @Override
    public void deleteMemberById(String memberId) {
        memberRepository.deleteById(memberId);
    }
}
