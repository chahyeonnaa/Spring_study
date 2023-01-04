package hyeona.example.practice;

import hyeona.example.practice.discount.DiscountPolicy;
import hyeona.example.practice.discount.FixDiscountPolicy;
import hyeona.example.practice.member.MemberRepository;
import hyeona.example.practice.member.MemberService;
import hyeona.example.practice.member.MemberServiceImpl;
import hyeona.example.practice.member.MemoryMemberRepository;
import hyeona.example.practice.order.OrderService;
import hyeona.example.practice.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService()
    {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService()
    {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }


}
