package hyeona.example.practice;

import hyeona.example.practice.member.Grade;
import hyeona.example.practice.member.Member;
import hyeona.example.practice.member.MemberService;
import hyeona.example.practice.member.MemberServiceImpl;
import hyeona.example.practice.order.Order;
import hyeona.example.practice.order.OrderService;
import hyeona.example.practice.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {


        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

//        AppConfig appConfig = new AppConfig();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();

        long memberId=1L;

        Member memberA = new Member( "memberA", memberId,Grade.VIP);
        memberService.join(memberA);
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("itemA = " + itemA);
    }
}
