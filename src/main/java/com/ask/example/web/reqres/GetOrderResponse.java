package com.ask.example.web.reqres;

import com.ask.example.domain.events.OrderState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOrderResponse {
    private Long orderId;
    private OrderState orderState;

    public GetOrderResponse() {
    }

    public GetOrderResponse(Long orderId, OrderState orderState) {
        this.orderId = orderId;
        this.orderState = orderState;
    }
}
