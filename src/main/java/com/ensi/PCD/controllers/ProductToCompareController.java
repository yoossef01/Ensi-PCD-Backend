package com.ensi.PCD.controllers;
import java.util.List;

import com.ensi.PCD.Services.ProductToCompareService;
import com.ensi.PCD.model.ProductToCompare;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apiproductToCompare"})
public class ProductToCompareController {
    @Autowired
    private ProductToCompareService ps;

    @GetMapping("/all/{id}")
    public List<ProductToCompare> getProductToCompareByClient(@PathVariable Integer id){
       return this.ps.getAllProductToComparesByClient( id );
    }
    @PostMapping("/add")
    public void addProductToCompare(@RequestBody ProductToCompare p){
        this.ps.createProductToCompare( p );
    }
    @DeleteMapping({"/del/{id}"})
    public void deleteProductToCompare(@PathVariable Integer id){
        this.ps.delete( id );
    }
}
