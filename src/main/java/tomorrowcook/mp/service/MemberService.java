package tomorrowcook.mp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    /**
     * 회원가입
     */
    @Transactional //변경
    public String join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getEmail();
    }
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers =
                memberRepository.findByEmail(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Member findOne(String email) {
        return memberRepository.findOne(email);
    }
}