package tmax.practice2.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmax.practice2.discount.DiscountPolicy;
import tmax.practice2.discount.FixDiscountPolicy;
import tmax.practice2.discount.RateDiscountPolicy;
import tmax.practice2.member.*;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
     @Override
    public Order createOrder(Long id, String itemName, int itemPrice) {
        Member member = memberRepository.findById(id);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(id, itemName, itemPrice, discountPrice);
    }
}