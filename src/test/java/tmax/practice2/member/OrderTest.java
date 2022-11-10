package tmax.practice2.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tmax.practice2.AppConfig;
import tmax.practice2.order.Order;
import tmax.practice2.order.OrderService;

@SpringBootTest
@Transactional
public class OrderTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void 할인금액반환(){
        //given
        Long id = 1L;
        Member member = new Member(id, "호영", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(id, "아맞나", 11000);
        System.out.println(order.toString());

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1100);
    }
}