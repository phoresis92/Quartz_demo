package tk.youngdk.quartz_demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public Member saveMember(Member member) {
        memberRepository.save(member);
        return member;
    }

    @Override
    public List<Member> getMember(String name) {
        return memberRepository.findByUserName(name);
    }

}
