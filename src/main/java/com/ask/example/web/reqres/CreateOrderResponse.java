package com.ask.example.web.reqres;

import lombok.Getter;

@Getter
public class CreateOrderResponse {
    private Long orderId;

    public CreateOrderResponse() {
    }

    public CreateOrderResponse(Long orderId) {
        this.orderId = orderId;
    }

}
