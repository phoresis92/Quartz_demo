package tk.youngdk.quartz_demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

}
