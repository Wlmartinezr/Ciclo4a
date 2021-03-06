/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retodos.repository.crud;

import com.retodos.model.Cleaningproducts;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Martinez Huertas
 */
public interface CleaningproductsCrudRepository extends MongoRepository<Cleaningproducts, String>{
  public List<Cleaningproducts> findByPriceLessThanEqual(double precio); 
  
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Cleaningproducts> findByDescriptionLike(String description);
}
