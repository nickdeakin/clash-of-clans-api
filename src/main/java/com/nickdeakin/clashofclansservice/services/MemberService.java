package com.nickdeakin.clashofclansservice.services;

import com.nickdeakin.clashofclansservice.domain.Member;
import com.nickdeakin.clashofclansservice.exceptions.MemberNotFoundException;
import com.nickdeakin.clashofclansservice.exceptions.ResourceIdURIBodyMismatchException;

import java.util.List;

public interface MemberService {

    List<Member> listMembers();

    Member createMember(Member member);

    Member getMemberById(String memberId) throws MemberNotFoundException;

    Member updateMemberById(String memberId, Member member) throws ResourceIdURIBodyMismatchException, MemberNotFoundException;

    void deleteMemberById(String memberId);

}
