package com.ensi.PCD.controllers;

import com.ensi.PCD.Services.VendeurService;
import com.ensi.PCD.model.Client;
import com.ensi.PCD.model.Vendeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/api"})
public class VendeurController {
    @Autowired
    private VendeurService vendeurService;

    @GetMapping("/vendeur/{id}")
    public Vendeur getVendeurById(@PathVariable Integer id) {
        return this.vendeurService.getVendeurById(id);
    }
    @GetMapping("/vendeur/email/{email}")
    public Vendeur getVendeurByEmail(@PathVariable String email){return this.vendeurService.getVendeurByEmail( email );}
    @PutMapping("/vendeur/update")
    public void updateVendeur(@RequestBody Vendeur v){
        this.vendeurService.SaveVendeur( v );
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable Integer id) {
        return this.vendeurService.getClientById(id);
    }
    @GetMapping("/client/email/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return this.vendeurService.getClientByEmail(email);
    }

}
