package tmax.practice2.member;

import tmax.practice2.member.Member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);

}
