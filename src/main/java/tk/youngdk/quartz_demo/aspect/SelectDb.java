package tk.youngdk.quartz_demo.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import tk.youngdk.quartz_demo.repository.gcp.GcpMemberRepository;
import tk.youngdk.quartz_demo.repository.local.LocalMemberRepository;
import tk.youngdk.quartz_demo.service.MemberServiceImpl;

@Component
@Aspect
@RequiredArgsConstructor
public class SelectDb {

    private final MemberServiceImpl memberService;
    private final GcpMemberRepository gcpMemberRepository;
    private final LocalMemberRepository localMemberRepository;

    @Pointcut("execution(* tk.youngdk.quartz_demo.controller.*Controller.*(..))") // 이런 패턴이 실행될 경우 수행
    public void loggerPointCut() {
    }

    @Around("loggerPointCut()")
    public Object selectDb(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("SelectDb.selectDb");
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof String) {
                String target = (String) arg;
                System.out.println("target = " + target);
            }
        }

        String companySeq = (String) joinPoint.getArgs()[1];
        System.out.println("companySeq = " + companySeq);
        System.out.println("companySeq = " + companySeq);

        if (companySeq.equals("100")) {
            System.out.println("100");
            memberService.setMemberRepository(gcpMemberRepository);
        }else if(companySeq.equals("101")){
            System.out.println("101");
            memberService.setMemberRepository(localMemberRepository);
        }else{
            throw new Throwable("Not in companySeq");
        }

//        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
//        User user = (User) session.getAttribute("user");
//        Object[] args = Arrays.stream(joinPoint.getArgs()).map(data -> { if(data instanceof User) { data = user; } return data; }).toArray();

//        return joinPoint.proceed(args);

        return joinPoint.proceed(new Object[] {(String) joinPoint.getArgs()[0], companySeq});



    }


}

