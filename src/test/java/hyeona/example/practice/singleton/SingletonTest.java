package hyeona.example.practice.singleton;

import hyeona.example.practice.AppConfig;
import hyeona.example.practice.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤 컨테이너와 싱글톤")
    void springContainer()
    {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        assertThat(memberService1).isSameAs(memberService2);
    }

}
