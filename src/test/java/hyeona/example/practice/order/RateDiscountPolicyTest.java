package hyeona.example.practice.order;

import hyeona.example.practice.discount.RateDiscountPolicy;
import hyeona.example.practice.member.Grade;
import hyeona.example.practice.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o()
    {
        Member memberA = new Member("memberA", 1L, Grade.VIP);
        int discount = discountPolicy.discount(memberA, 10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 정책이 적용되면 안된다.")
    void vip_x()
    {
        Member memberA = new Member("memberA", 1L, Grade.Basic);
        int discount = discountPolicy.discount(memberA, 10000);
        assertThat(discount).isEqualTo(0);
    }
}
