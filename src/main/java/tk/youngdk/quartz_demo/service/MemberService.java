package tk.youngdk.quartz_demo.service;

import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.dto.request.BaseRequestDto;
import tk.youngdk.quartz_demo.exception.InvalidCompanySeqError;
import tk.youngdk.quartz_demo.repository.MemberRepository;

import java.util.List;

public interface MemberService {

    Member saveMember(BaseRequestDto baseRequestDto, Member member) throws InvalidCompanySeqError;

    List<Member> getMember(BaseRequestDto baseRequestDto, String name) throws InvalidCompanySeqError;

}
