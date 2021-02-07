package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll(){
        List<Order> orders= orderRepository.findAll();
        if(orders.isEmpty())
            throw new NotFoundException("There is no any order.");
        return orders;
    }

    public void save(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(Long id){
        Order order = orderRepository.findOrderById(id);
        if(order == null)
            throw new NotFoundException("Order has already been deleted");
        orderRepository.delete(order);
    }

}
