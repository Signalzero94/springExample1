package tmax.practice2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tmax.practice2.discount.DiscountPolicy;
import tmax.practice2.discount.FixDiscountPolicy;
import tmax.practice2.discount.RateDiscountPolicy;
import tmax.practice2.member.*;
import tmax.practice2.order.OrderService;
import tmax.practice2.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
}
