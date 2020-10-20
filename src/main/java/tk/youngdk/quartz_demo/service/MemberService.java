package tk.youngdk.quartz_demo.service;

import tk.youngdk.quartz_demo.domain.Member;

import java.util.List;

public interface MemberService {
    Member saveMember(Member member);

    List<Member> getMember(String name);
}
