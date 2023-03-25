package com.ensi.PCD.controllers;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//


import com.ensi.PCD.Services.categoryServices;
import com.ensi.PCD.Services.productService;
import com.ensi.PCD.model.product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apiproduit"})
public class productController {
 categoryServices cc;
 productService sp;

 @GetMapping({"/all"})
 public List<product> getAllProducts() {
     return this.sp.getAllProducts();
 }

 @GetMapping({"/productsByCat/{id}"})
 public List<product> getproduitsparCate(@PathVariable Integer id) {
     return this.sp.getProductsByCat(id);
 }

 @DeleteMapping({"/del/{id}"})
 public void delete(@PathVariable String id) {
     this.sp.deleteProduct(id);
 }

 @PostMapping({"/add"})
 public void AjouterProduit(@RequestParam(value = "file",required = false) MultipartFile file, @RequestParam("product") String product) {
     try {
         product p = (product)(new ObjectMapper()).readValue(product, product.class);
         this.sp.saveProduct(p, file);
     } catch (JsonMappingException var4) {
         var4.printStackTrace();
     } catch (JsonProcessingException var5) {
         var5.printStackTrace();
     }

 }

 @GetMapping({"/productById/{id}"})
 public product getProduitbById(@PathVariable String id) {
     return this.sp.getProduit(id);
 }

 @PostMapping({"/update"})
 public void modifierProduit(@RequestParam(value = "file",required = false) MultipartFile file, @RequestParam("product") String product) {
     this.AjouterProduit(file, product);
 }

 @GetMapping(
     path = {"/getimage/{id}"},
     produces = {"image/png"}
 )
 public byte[] getImage(@PathVariable String id) {
     return this.sp.getImage(id);
 }

 public productController(final categoryServices cc, final productService sp) {
     this.cc = cc;
     this.sp = sp;
 }
}
