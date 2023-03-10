package hyeona.example.practice.member;

import hyeona.example.practice.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void BeforeEach()
    {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join()
    {
        // given
        Member member = new Member("memberA", 1L, Grade.VIP);

        // when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);

        // then
        assertThat(member).isEqualTo(member1);
    }
}
