package tmax.practice2.discount;

import tmax.practice2.member.Grade;
import tmax.practice2.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRateAmount = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price * discountRateAmount / 100;
        }else{
            return 0;
        }
    }
}
