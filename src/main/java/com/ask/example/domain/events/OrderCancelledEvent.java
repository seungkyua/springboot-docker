package com.ask.example.domain.events;

public class OrderCancelledEvent implements OrderEvent {

  private OrderDetails orderDetails;

  public OrderCancelledEvent() {
  }

  public OrderCancelledEvent(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
  }

  public OrderDetails getOrderDetails() {
    return orderDetails;
  }
}
