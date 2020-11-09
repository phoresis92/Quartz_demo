package tk.youngdk.quartz_demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.youngdk.quartz_demo.config.datasource.DataSourceLookupKeyContextHolder;
import tk.youngdk.quartz_demo.config.datasource.DataSourceType;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.dto.request.BaseRequestDto;
import tk.youngdk.quartz_demo.exception.InvalidCompanySeqError;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    @Autowired
    TestDowhatService testDowhatService;

    @Test
    void saveMember() {
    }

    @Test
    void getMember() throws InvalidCompanySeqError {

        System.out.println("memberService = " + memberService);

//        List<Member> test1Name = memberService.getMember(new BaseRequestDto("100", "1000"), "test1");
        memberService.saveMember(new BaseRequestDto("100", "1000"), new Member("test1"));

//        DataSourceLookupKeyContextHolder.set(DataSourceType.RAMADA);

        testDowhatService.saveMember(new BaseRequestDto("100", "1000"), new Member("test2"));
//        List<Member> test2Name = memberService.getMember(new BaseRequestDto("100", "1000"), "test2");


        memberService.saveMember(new BaseRequestDto("100", "1000"), new Member("test3"));


    }
}