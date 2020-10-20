package tk.youngdk.quartz_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.service.MemberService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final MemberService memberService;

    @GetMapping("/test/{param}")
    public Member test(
            @PathVariable("param") String param,
            @RequestParam("companySeq") String companySeq
    ){

        System.out.println("param = " + param);
        System.out.println("companySeq = " + companySeq);

        List<Member> members = memberService.getMember(param);
        members.stream()
                .forEach(m -> System.out.println("m = " + m));

        return memberService.saveMember(new Member(param));

    }
}
