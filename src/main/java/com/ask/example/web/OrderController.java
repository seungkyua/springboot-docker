package com.ask.example.web;

import com.ask.example.domain.Order;
import com.ask.example.domain.OrderRepository;
import com.ask.example.domain.events.OrderDetails;
import com.ask.example.service.OrderService;
import com.ask.example.web.reqres.CreateOrderRequest;
import com.ask.example.web.reqres.CreateOrderResponse;
import com.ask.example.web.reqres.GetOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class OrderController {

    private OrderService orderService;
    private OrderRepository orderRepository;
//    private DomainSnapshotExportService<Order> domainSnapshotExportService;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderRepository orderRepository) {

        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

//    public OrderController(OrderService orderService,
//                           OrderRepository orderRepository,
//                           DomainSnapshotExportService<Order> domainSnapshotExportService) {
//
//        this.orderService = orderService;
//        this.orderRepository = orderRepository;
//        this.domainSnapshotExportService = domainSnapshotExportService;
//    }

    @RequestMapping(path = "/orders", method = RequestMethod.POST)
    public CreateOrderResponse createOrder(
            @RequestBody CreateOrderRequest createOrderRequest) {

        log.info("customId = {}, amount = {}",
                createOrderRequest.getCustomerId(), createOrderRequest.getOrderTotal());

        Order order = orderService.createOrder(
                new OrderDetails(createOrderRequest.getCustomerId(),
                        createOrderRequest.getOrderTotal()));
        return new CreateOrderResponse(order.getId());
    }

    @GetMapping(path="/orders/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(
            @PathVariable Long orderId) {
        return orderRepository
                .findById(orderId)
                .map(this::makeSuccessfulResponse)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path="/orders/{orderId}/cancel")
    public ResponseEntity<GetOrderResponse> cancelOrder(
            @PathVariable Long orderId) {
        Order order = orderService.cancelOrder(orderId);
        return makeSuccessfulResponse(order);
    }

//    @RequestMapping(value = "/orders/make-snapshot", method = RequestMethod.POST)
//    public String makeSnapshot() {
//        return JSonMapper.toJson(domainSnapshotExportService.exportSnapshots());
//    }

    private ResponseEntity<GetOrderResponse> makeSuccessfulResponse(Order order) {
        return new ResponseEntity<>(new GetOrderResponse(order.getId(), order.getState()), HttpStatus.OK);
    }
}
