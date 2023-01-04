package hyeona.example.practice.order;

import hyeona.example.practice.AppConfig;
import hyeona.example.practice.OrderApp;
import hyeona.example.practice.member.Grade;
import hyeona.example.practice.member.Member;
import hyeona.example.practice.member.MemberService;
import hyeona.example.practice.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach()
    {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


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
