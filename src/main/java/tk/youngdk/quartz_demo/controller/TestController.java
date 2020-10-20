package tk.youngdk.quartz_demo.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.dto.request.BaseRequestDto;
import tk.youngdk.quartz_demo.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final MemberService memberService;

    @GetMapping("/test/{param}")
    public Member postMember(
            @Valid BaseRequestDto baseRequestDto,
            @PathVariable("param") String param
//            @RequestParam("companySeq") String companySeq
    ){

        System.out.println("param = " + param);
        System.out.println("baseRequestDto = " + baseRequestDto);

        return memberService.saveMember(new Member(param));

    }

    @PostMapping("/test")
    public List<Member> memberList(
            @Valid MemberListRequestDto requestDto
    ){

        System.out.println("requestDto = " + requestDto);

        List<Member> members = memberService.getMember(requestDto.getName());
//        members.stream()
//                .forEach(m -> System.out.println("m = " + m));

        return members;

    }

    @Data
    @ToString(callSuper = true)
    static class MemberListRequestDto extends BaseRequestDto {
        private String name;
    }
}
