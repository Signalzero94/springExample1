package tmax.practice2.discount;

import tmax.practice2.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price); // 할인된 금액
}
