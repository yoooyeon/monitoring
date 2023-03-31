package com.example.actuator.order;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Timed("my.order")
@Slf4j
public class OrderServiceImpl implements OrderService {
    private AtomicInteger stock = new AtomicInteger(100);


    @Override
    public void order() {
        log.info("order");
        stock.decrementAndGet();
        sleep(500);
    }

    @Override
    public void cancel() {
        log.info("cancel");
        sleep(500);
        stock.incrementAndGet();
    }

    @Override
    public AtomicInteger getStock() {
        log.info("getStock");
        sleep(500);

        return stock;
    }

    private void sleep(int l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
