package com.ensi.PCD.controllers;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//



import com.ensi.PCD.Dao.categoryRepository;
import com.ensi.PCD.Services.categoryServices;
import com.ensi.PCD.model.category;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apicategory"})
public class categoryController {
 categoryServices sc;
    private final com.ensi.PCD.Dao.categoryRepository categoryRepository;

    public categoryController(categoryServices sc,
                              categoryRepository categoryRepository) {
     this.sc = sc;
        this.categoryRepository = categoryRepository;
    }

 @GetMapping({"/all"})
 public List<category> getAllCategories() {
     return this.sc.getAllCategories();
 }
@GetMapping("/categoriesByVend/{id}")
public  List<category> getAllCategoriesByVendeur(@PathVariable Integer id){return this.sc.getAllCategoriesByVendeur( id );}
 @PostMapping({"/add"})
 public category ajouterCategorie(@RequestBody category c) {
     category newCategory = this.sc.save(c);
     return newCategory;
 }
    @PutMapping("/update/{id}")
    public ResponseEntity<category> modifierCategorie(@PathVariable Integer id, @RequestBody category categorieModifiee) {
        Optional<category> categorieOptional = categoryRepository.findById(id);

        if (!categorieOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        category categorieExistante = categorieOptional.get();
        categorieExistante.setNom(categorieModifiee.getNom());

        category categorieMiseAJour = categoryRepository.save(categorieExistante);
        return ResponseEntity.ok(categorieMiseAJour);
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

