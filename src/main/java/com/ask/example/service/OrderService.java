package com.ask.example.service;

import com.ask.example.domain.Order;
import com.ask.example.domain.OrderRepository;
import com.ask.example.domain.events.OrderDetails;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

//    private final DomainEventPublisher domainEventPublisher;
    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    public OrderService(DomainEventPublisher domainEventPublisher, OrderRepository orderRepository) {
//        this.domainEventPublisher = domainEventPublisher;
//        this.orderRepository = orderRepository;
//    }

    @Transactional
    public Order createOrder(OrderDetails orderDetails) {
//        new RuntimeException().printStackTrace();
        ResultWithEvents<Order> orderWithEvents = Order.createOrder(orderDetails);
        Order order = orderWithEvents.result;
        orderRepository.save(order);
//        domainEventPublisher.publish(Order.class, order.getId(), orderWithEvents.events);
        return order;
    }

    public void approveOrder(Long orderId) {
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("order with id %s not found", orderId)));
        order.noteCreditReserved();
//        domainEventPublisher.publish(Order.class,
//                orderId, singletonList(new OrderApprovedEvent(order.getOrderDetails())));
    }

    public void rejectOrder(Long orderId) {
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("order with id %s not found", orderId)));
        order.noteCreditReservationFailed();
//        domainEventPublisher.publish(Order.class,
//                orderId, singletonList(new OrderRejectedEvent(order.getOrderDetails())));
    }

    @Transactional
    public Order cancelOrder(Long orderId) {
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("order with id %s not found", orderId)));
        order.cancel();
//        domainEventPublisher.publish(Order.class,
//                orderId, singletonList(new OrderCancelledEvent(order.getOrderDetails())));
        return order;
    }
}
