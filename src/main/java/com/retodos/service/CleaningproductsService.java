/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retodos.service;

import com.retodos.model.Cleaningproducts;
import com.retodos.repository.CleaningproductsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martinez Huertas
 */
@Service
public class CleaningproductsService {
    
    @Autowired
    private CleaningproductsRepository prodrepositorio;
    
    public List<Cleaningproducts> getAll() {
    return prodrepositorio.getAll();

    }
    public Optional<Cleaningproducts> getClothe (String reference){
        return prodrepositorio.getClothe(reference);
    }        

    public Cleaningproducts create(Cleaningproducts cleaningproducts) {
        if (cleaningproducts.getReference()== null) {
            return cleaningproducts;
        } else {
            return prodrepositorio.create(cleaningproducts);
        }
    }

    public Cleaningproducts update(Cleaningproducts cleaningproducts) {
        if (cleaningproducts.getReference()!= null) {
            Optional<Cleaningproducts> cleaningproductsDb = prodrepositorio.getClothe(cleaningproducts.getReference());
            if (!cleaningproductsDb.isEmpty()) {
                
                if (cleaningproducts.getBrand()!= null) {
                    cleaningproductsDb.get().setBrand(cleaningproducts.getBrand());
                }
                 if (cleaningproducts.getCategory()!= null) {
                    cleaningproductsDb.get().setCategory(cleaningproducts.getCategory());
                }
                if (cleaningproducts.getDescription()!= null) {
                    cleaningproductsDb.get().setDescription(cleaningproducts.getDescription());
                }
                if (cleaningproducts.getMaterial()!= null) {
                    cleaningproductsDb.get().setMaterial(cleaningproducts.getMaterial());
                }
                if (cleaningproducts.getPresentacion()!= null) {
                    cleaningproductsDb.get().setPresentacion(cleaningproducts.getPresentacion());
                }

                if (cleaningproducts.getPrice()!= 0.0) {
                    cleaningproductsDb.get().setPrice(cleaningproducts.getPrice());
                }
                if (cleaningproducts.getQuantity()!= 0) {
                    cleaningproductsDb.get().setQuantity(cleaningproducts.getQuantity());
                }
                if (cleaningproducts.getPhotography()!= null) {
                    cleaningproductsDb.get().setPhotography(cleaningproducts.getPhotography());
                }
                
                cleaningproductsDb.get().setAvailability(cleaningproducts.isAvailability());
                prodrepositorio.update(cleaningproductsDb.get());
                return cleaningproductsDb.get();
                
            }else{
                return cleaningproducts;
            }
        }else{
              return cleaningproducts;  
              }
    }
        public boolean delete(String reference) {
            Boolean aBoolean = getClothe(reference).map(cleaningproducts ->{
                prodrepositorio.delete(cleaningproducts);
                return true;
            }).orElse(false);
        return aBoolean;

    }
    public List<Cleaningproducts> productByPrice(double price) {
    return prodrepositorio.productByPrice(price);
    }
    
}
