package hyeona.example.practice.discount;

import hyeona.example.practice.member.Member;

public interface DiscountPolicy {

    // 등급 확인하고, 할인 금액 반환
    int discount(Member member, int price);
}
