package tmax.practice2.member;

import tmax.practice2.member.Member;

import java.util.Optional;

public interface MemberService {
    void join(Member member);
    Member findMember(Long id);
}
