package hyeona.example.practice.order;

import hyeona.example.practice.discount.DiscountPolicy;
import hyeona.example.practice.discount.FixDiscountPolicy;
import hyeona.example.practice.member.Member;
import hyeona.example.practice.member.MemberRepository;
import hyeona.example.practice.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(member, itemPrice);

        return new Order(itemPrice, memberId,itemName, discount);
    }
}
