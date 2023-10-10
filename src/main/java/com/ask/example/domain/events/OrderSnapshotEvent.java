package com.ask.example.domain.events;

import com.ask.example.common.Money;
import io.eventuate.tram.events.common.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSnapshotEvent implements DomainEvent {
  private Long id;
  private Long customerId;
  private Money orderTotal;
  private OrderState orderState;

  public OrderSnapshotEvent() {
  }

  public OrderSnapshotEvent(Long id, Long customerId, Money orderTotal, OrderState orderState) {
    this.id = id;
    this.customerId = customerId;
    this.orderTotal = orderTotal;
    this.orderState = orderState;
  }

}
