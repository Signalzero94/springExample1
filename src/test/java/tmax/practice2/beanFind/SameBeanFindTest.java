package tmax.practice2.beanFind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tmax.practice2.discount.DiscountPolicy;
import tmax.practice2.member.Member;
import tmax.practice2.member.MemberRepository;
import tmax.practice2.member.MemberService;
import tmax.practice2.member.MemoryMemberRepository;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    void 중복타입빈검색() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    void 중복타입빈은이름등록으로(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    void 중복타입빈모두조회(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String s : beansOfType.keySet()) {
            System.out.println(s);
            System.out.println(beansOfType.get(s));
            System.out.println(beansOfType);
            assertThat(beansOfType.size()).isEqualTo(2);
        }
    }
        @Configuration
        static class SameBeanConfig{
        @Bean
            public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
            public MemberRepository memberRepository2(){
                return new MemoryMemberRepository();
            }
        }
}
