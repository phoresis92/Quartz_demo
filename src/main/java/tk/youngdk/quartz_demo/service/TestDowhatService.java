package tk.youngdk.quartz_demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.dto.request.BaseRequestDto;
import tk.youngdk.quartz_demo.exception.InvalidCompanySeqError;
import tk.youngdk.quartz_demo.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class TestDowhatService {

    private final MemberRepository memberRepository;

    public Member saveMember(BaseRequestDto baseRequestDto, Member member) throws InvalidCompanySeqError {
        return memberRepository.save(member);
    }

}
