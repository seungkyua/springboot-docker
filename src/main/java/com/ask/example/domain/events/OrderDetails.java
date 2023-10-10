package com.ask.example.domain.events;

import com.ask.example.common.Money;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Getter
@Embeddable
public class OrderDetails {

    private Long customerId;

    @Embedded
    private Money orderTotal;

    public OrderDetails() {}

    public OrderDetails(Long customerId, Money orderTotal) {
        this.customerId = customerId;
        this.orderTotal = orderTotal;
    }
}
