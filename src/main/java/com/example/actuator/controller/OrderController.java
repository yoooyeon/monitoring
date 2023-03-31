package com.example.actuator.controller;

import com.example.actuator.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
public class OrderController {
    private final OrderService orderService;

    @GetMapping("order")
    public String order() throws InterruptedException {
        log.info("order");
        orderService.order();
        return "order";
    }

    @GetMapping("cancel")
    public String cancel() {
        log.info("cancel");
        orderService.cancel();
        return "cancel";
    }

    @GetMapping("stock")
    public String stock() {
        log.info("stock");
        orderService.getStock();
        return "stock " + orderService.getStock();
    }
}
