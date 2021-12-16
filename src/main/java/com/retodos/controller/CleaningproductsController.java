package com.retodos.controller;

import com.retodos.model.Cleaningproducts;
import com.retodos.service.CleaningproductsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Martinez Huertas
 */
@RestController
@RequestMapping("/api/cleaningproduct")
@CrossOrigin("*")
public class CleaningproductsController {

    @Autowired
    private CleaningproductsService servicio;

    @GetMapping("/all")
    public List<Cleaningproducts> getAll() {
        return servicio.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cleaningproducts> getClothe(@PathVariable("reference") String reference) {
        return servicio.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaningproducts create(@RequestBody Cleaningproducts gadget) {
        return servicio.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaningproducts update(@RequestBody Cleaningproducts gadget) {
        return servicio.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return servicio.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Cleaningproducts> productByPrice(@PathVariable("price") double precio) {
        return servicio.productByPrice(precio);
    }
    @GetMapping("/description/{description}")
    public List<Cleaningproducts> findByDescriptionLike(@PathVariable("description") String description) {
        return servicio.findByDescriptionLike(description);
    }    

}
