package tmax.practice2.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import tmax.practice2.member.Grade;
import tmax.practice2.member.Member;
import tmax.practice2.member.MemberService;
import tmax.practice2.member.MemberServiceImpl;
import tmax.practice2.order.Order;
import tmax.practice2.order.OrderService;
import tmax.practice2.order.OrderServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    MemberService memberService;
    OrderService orderService;

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void 적용가능(){
        //given
        Long id = 1L;
        Member member = new Member(id, "호영", Grade.VIP);

        //when
        int discountPrice = discountPolicy.discount(member, 11000);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(1100);
    }
    @Test
    @DisplayName("VIP가 아니면 할인 적용 x")
    void 적용불가능(){
        //given
        Member member = new Member(1L, "호영", Grade.BASIC);

        //when
        int discountPrice = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(0);

    }





}