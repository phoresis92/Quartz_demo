package tk.youngdk.quartz_demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.dto.request.BaseRequestDto;
import tk.youngdk.quartz_demo.exception.InvalidCompanySeqError;
import tk.youngdk.quartz_demo.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public Member saveMember(BaseRequestDto baseRequestDto, Member member) throws InvalidCompanySeqError {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getMember(BaseRequestDto baseRequestDto, String name) throws InvalidCompanySeqError {
        return memberRepository.findByUserName(name);
    }
}
