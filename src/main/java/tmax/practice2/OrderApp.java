package tmax.practice2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tmax.practice2.member.Grade;
import tmax.practice2.member.Member;
import tmax.practice2.member.MemberService;
import tmax.practice2.order.Order;
import tmax.practice2.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long id = 1L;
        Member member = new Member(id, "호영", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(id, "맥북", 2000);

        System.out.println(order);

    }
}
