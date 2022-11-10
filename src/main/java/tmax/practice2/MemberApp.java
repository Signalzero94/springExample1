package tmax.practice2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tmax.practice2.member.Grade;
import tmax.practice2.member.Member;
import tmax.practice2.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "호영", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
    }
}
