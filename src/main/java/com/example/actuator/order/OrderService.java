package com.example.actuator.order;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public interface OrderService {
    void order() ;

    void cancel();

    AtomicInteger getStock();
}
