package hyeona.example.practice.order;

import hyeona.example.practice.member.Grade;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
