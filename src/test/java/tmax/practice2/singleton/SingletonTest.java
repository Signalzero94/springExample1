package tmax.practice2.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tmax.practice2.AppConfig;
import tmax.practice2.member.Member;
import tmax.practice2.member.MemberService;

public class SingletonTest {

    @Test
    void 스프링없는_순수한_DI_컨테이너(){
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    void 싱글톤패턴을_적용한_객체사용(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        Assertions.assertThat(instance1).isSameAs(instance2);
        //same ==
        //equal equals

    }


}
