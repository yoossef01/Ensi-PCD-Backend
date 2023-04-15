package com.ensi.PCD.controllers;

import com.ensi.PCD.Services.VendeurService;
import com.ensi.PCD.model.Client;
import com.ensi.PCD.model.Vendeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apivendeur"})
public class VendeurController {
    @Autowired
    private VendeurService vendeurService;

    @GetMapping("/vendeur/{id}")
    public Vendeur getVendeurById(@PathVariable Integer id) {
        return this.vendeurService.getVendeurById(id);
    }
    @PutMapping("/update")
    public void updateVendeur(@RequestBody Vendeur v){
        this.vendeurService.SaveVendeur( v );
    }
    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable Integer id) {
        return this.vendeurService.getClientById(id);
    }

}
