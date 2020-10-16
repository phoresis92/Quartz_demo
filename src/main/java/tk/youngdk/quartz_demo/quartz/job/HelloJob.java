package tk.youngdk.quartz_demo.quartz.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.repository.MemberRepository;
import tk.youngdk.quartz_demo.service.MemberService;

@Slf4j
@Component
@RequiredArgsConstructor
public class HelloJob implements Job {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.error("HelloJob");

        Member t1 = new Member("t1");

        memberService.saveMember(t1);

        log.error(memberRepository.findById(t1.getId()).toString());

    }
}
