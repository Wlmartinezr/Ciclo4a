/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retodos.repository.crud;

import com.retodos.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Martinez Huertas
 */
public interface OrderCrudRepository extends MongoRepository<Order,Integer> {
    
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    
    @Query("{'status': ?0}")
    List<Order> findByStatus(final String status);
    
    @Query("{'date': ?0}")
    List<Order> findByDate(final String date);
    
    Optional<Order> findTopByOrderByIdDesc();
    
    
}
