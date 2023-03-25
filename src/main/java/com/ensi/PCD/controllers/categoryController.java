package com.ensi.PCD.controllers;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//



import com.ensi.PCD.Services.categoryServices;
import com.ensi.PCD.model.category;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apicategory"})
public class categoryController {
 categoryServices sc;

 public categoryController(categoryServices sc) {
     this.sc = sc;
 }

 @GetMapping({"/all"})
 public List<category> getAllCategories() {
     return this.sc.getAllCategories();
 }

 @PostMapping({"/add"})
 public category ajouterCategorie(@RequestBody category c) {
     category newCategory = this.sc.save(c);
     return newCategory;
 }

 @DeleteMapping({"/del/{id}"})
 public void supprimerCategorie(@PathVariable Integer id) {
     this.sc.deleteCategorie(id);
 }

 @GetMapping({"/catgorieById/{id}"})
 public category getCategory(@PathVariable Integer id) {
     return this.sc.getCategory(id);
 }
}

