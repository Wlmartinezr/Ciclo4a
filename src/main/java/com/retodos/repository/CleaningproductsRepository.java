/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retodos.repository;

import com.retodos.model.Cleaningproducts;
import com.retodos.repository.crud.CleaningproductsCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Martinez Huertas
 */
@Repository
public class CleaningproductsRepository {
    
    @Autowired
    private CleaningproductsCrudRepository repository;
    
    public List<Cleaningproducts> getAll(){
        return repository.findAll();
    }
    public Optional<Cleaningproducts> getClothe (String reference){
        return repository.findById(reference);
    }    
    
    public Cleaningproducts create (Cleaningproducts clothe){
        return repository.save(clothe);
    }
    
    public void update(Cleaningproducts clothe){
        repository.save(clothe);
    }
    public void delete(Cleaningproducts clothe){
        repository.delete(clothe);
    }
    public List<Cleaningproducts> productByPrice(double precio){
        return repository.findByPriceLessThanEqual(precio);
    }    
    
}
