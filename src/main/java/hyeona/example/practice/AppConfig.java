package hyeona.example.practice;

import hyeona.example.practice.discount.DiscountPolicy;
import hyeona.example.practice.discount.FixDiscountPolicy;
import hyeona.example.practice.discount.RateDiscountPolicy;
import hyeona.example.practice.member.MemberRepository;
import hyeona.example.practice.member.MemberService;
import hyeona.example.practice.member.MemberServiceImpl;
import hyeona.example.practice.member.MemoryMemberRepository;
import hyeona.example.practice.order.OrderService;
import hyeona.example.practice.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService()
    {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService()
    {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    private static DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
