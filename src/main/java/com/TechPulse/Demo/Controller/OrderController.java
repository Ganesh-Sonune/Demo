package com.TechPulse.Demo.Controller;

import com.TechPulse.Demo.Entity.Order;
import com.TechPulse.Demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public Order createOrder(
            @PathVariable Long userId,
            @RequestBody Order order) {

        return orderService.createOrder(userId, order);
    }
}