/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retodos.service;

import com.retodos.model.Order;
import com.retodos.model.User;
import com.retodos.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martinez Huertas
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();

    }
    public Optional<Order> getOrder(int id){
        return orderRepository.getOrder(id);
    }
    public Order create(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.create(order);
        } 
    } 
    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            }else{
                return order;
            }
        }else{
            return order;
        }
    }
    public boolean delete(int id) {
       Boolean aBoolean = getOrder(id).map(order -> {
           orderRepository.delete(order);
           return true;
       }).orElse(false);
       return aBoolean;
    }
    public List<Order> findByZone(String zona){
        return orderRepository.findByZone(zona);
    
    }
        //Reto 4: Ordenes de un asesor
    public List<Order> ordersSalesManByID(int id) {
        return orderRepository.ordersSalesManByID(id);
    }
    
    //Reto 4: Ordenes de un asesor x Fecha
    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return orderRepository.ordersSalesManByDate(dateStr, id);
    }
    
    //Reto 4: Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, int id) {
        return orderRepository.ordersSalesManByState(state, id);
    }
}
