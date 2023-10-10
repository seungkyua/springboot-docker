package com.ask.example.web.reqres;

import com.ask.example.common.Money;
import lombok.Getter;

@Getter
public class CreateOrderRequest {
    private Money orderTotal;
    private Long customerId;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(Long customerId, Money orderTotal) {
        this.customerId = customerId;
        this.orderTotal = orderTotal;
    }
}
