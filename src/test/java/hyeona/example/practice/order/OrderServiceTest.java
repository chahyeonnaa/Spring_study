package hyeona.example.practice.order;

import hyeona.example.practice.member.Grade;
import hyeona.example.practice.member.Member;
import hyeona.example.practice.member.MemberService;
import hyeona.example.practice.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder()
    {
        long memberId =1L;
        Member memberA = new Member("memberA", memberId, Grade.VIP);
        memberService.join(memberA);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }
}
