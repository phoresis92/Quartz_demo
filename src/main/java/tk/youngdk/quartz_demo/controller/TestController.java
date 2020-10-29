package tk.youngdk.quartz_demo.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.dto.request.BaseRequestDto;
import tk.youngdk.quartz_demo.exception.InvalidCompanySeqError;
import tk.youngdk.quartz_demo.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final MemberService memberService;

//    @GetMapping("/test/{param}")
    @PostMapping("/test/{param}")
    public Member postMember(
            @Valid BaseRequestDto baseRequestDto,
            @PathVariable("param") String param,
            String testVal
//            MemberService memberService
//            @RequestParam("companySeq") String companySeq
    ) throws InvalidCompanySeqError {

        System.out.println("baseRequestDto = " + baseRequestDto);
        System.out.println("param = " + param);
        System.out.println("memberService = " + memberService);
        System.out.println("testVal = " + testVal);

//        Thread.sleep(1000L);

        Member saveMember = memberService.saveMember(baseRequestDto, new Member(param));

        return saveMember;
    }

//    @PostMapping("/test")
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<List<Member>> memberList(
//            @Valid MemberListRequestDto requestDto
//    ){
//
//        System.out.println("requestDto = " + requestDto);
//
//        List<Member> members = memberService.getMember(requestDto.getName());
////        members.stream()
////                .forEach(m -> System.out.println("m = " + m));
//
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//        if (members.size() == 0) {
//            status = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return new ResponseEntity(members, status);
//    }
//
//    @Data
//    @ToString(callSuper = true)
//    static class MemberListRequestDto extends BaseRequestDto {
//        private String name;
//    }
}
