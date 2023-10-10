package com.ask.example;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableJpaRepositories
//@EnableAutoConfiguration
//@Import({OptimisticLockingDecoratorConfiguration.class,
//        SnapshotConfiguration.class})
public class OrderConfiguration {

//  @Bean
//  public CustomerEventConsumer orderEventConsumer() {
//    return new CustomerEventConsumer();
//  }
//
//  @Bean
//  public DomainEventDispatcher domainEventDispatcher(CustomerEventConsumer customerEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
//    return domainEventDispatcherFactory.make("customerServiceEvents", customerEventConsumer.domainEventHandlers());
//  }

//  @Bean
//  public DomainSnapshotExportService<Order> domainSnapshotExportService(OrderRepository orderRepository,
//                                                                        DomainSnapshotExportServiceFactory<Order> domainSnapshotExportServiceFactory) {
//    return domainSnapshotExportServiceFactory.make(
//            Order.class,
//            orderRepository,
//            order -> {
//              DomainEvent domainEvent = new OrderSnapshotEvent(order.getId(),
//                      order.getOrderDetails().getCustomerId(),
//                      order.getOrderDetails().getOrderTotal(),
//                      order.getState());
//
//              return new DomainEventWithEntityId(order.getId(), domainEvent);
//            },
//            new DBLockService.TableSpec("orders", "order0_"),
//            "MySqlReader");
//  }
}
