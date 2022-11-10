package tmax.practice2.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tmax.practice2.AppConfig;

@SpringBootTest
public class MemberTest {

    MemberService memberService;

    @BeforeEach //각 테스트가 실행되기 전에 먼저 실행
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void 가입(){
        //given
        Member member = new Member(1L,"호영", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }

}
