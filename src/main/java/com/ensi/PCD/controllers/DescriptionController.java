package com.ensi.PCD.controllers;

import com.ensi.PCD.Services.DescriptionService;
import com.ensi.PCD.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apidescription"})
public class DescriptionController {
    @Autowired
    private DescriptionService descriptionService;

    @GetMapping("/{id}")
    public Description GetDescription(@PathVariable String id){
       return this.descriptionService.getDescriptionById( id );
    }
    @GetMapping("/all")
    public List<Description> GetAllDescription(){return this.descriptionService.getAllDescription();}
   @GetMapping("/product/{id}")
   public Description GetDescriptionByProduct(@PathVariable String id){
      return   this.descriptionService.getDescriptionByProduct( id );
   }

    @PostMapping("/add")
    public void AddDescription(@RequestBody Description D){
        this.descriptionService.createDescription( D );
    }
    @PutMapping
    public void UpdateDescription(@RequestBody Description D){
        this.AddDescription( D );
    }
}
