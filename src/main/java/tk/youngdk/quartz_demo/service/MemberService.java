package tk.youngdk.quartz_demo.service;

import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.repository.MemberRepository;

import java.util.List;

public interface MemberService {
    public Member saveMember(Member member);

    public List<Member> getMember(String name);
}
