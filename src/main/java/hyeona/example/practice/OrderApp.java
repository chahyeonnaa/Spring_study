package hyeona.example.practice;

import hyeona.example.practice.member.Grade;
import hyeona.example.practice.member.Member;
import hyeona.example.practice.member.MemberService;
import hyeona.example.practice.member.MemberServiceImpl;
import hyeona.example.practice.order.Order;
import hyeona.example.practice.order.OrderService;
import hyeona.example.practice.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();

        long memberId=1L;

        Member memberA = new Member( "memberA", memberId,Grade.VIP);
        memberService.join(memberA);
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("itemA = " + itemA);
    }
}
