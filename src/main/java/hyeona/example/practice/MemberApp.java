package hyeona.example.practice;

import hyeona.example.practice.member.Grade;
import hyeona.example.practice.member.Member;
import hyeona.example.practice.member.MemberService;
import hyeona.example.practice.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member("memberA", 1L, Grade.VIP);

        memberService.join(member);

        Member member1 = memberService.findMember(1L);

        System.out.println("member = " + member.getName());
        System.out.println("member1.getName() = " + member1.getName());

    }
}
