package com.TechPulse.Demo.service;

import com.TechPulse.Demo.Entity.Order;
import com.TechPulse.Demo.Entity.User;
import com.TechPulse.Demo.repository.OrderRepository;
import com.TechPulse.Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    // 1️⃣ Create Order for a User
    public Order createOrder(Long userId, Order order) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + userId));

        order.setUser(user);
        return orderRepository.save(order);
    }

    // 2️⃣ Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 3️⃣ Get orders by user id
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // 4️⃣ Delete order
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
