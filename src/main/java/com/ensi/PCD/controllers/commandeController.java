package com.ensi.PCD.controllers;
import com.ensi.PCD.Services.commandeServices;
import com.ensi.PCD.model.commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apicommande"})
public class commandeController {
    @Autowired
    private commandeServices CommandeService;

    @GetMapping("/{id}")
    public ResponseEntity<commande> findById(@PathVariable Integer id) {
        commande commande = CommandeService.getCommandeById(id);
        if (commande != null) {
            return ResponseEntity.ok( commande );
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping({"/all"})
    public List<commande> getAllCommandes() {
        return this.CommandeService.getAllCommandes();
    }
    @GetMapping("/commandesByClient/{id}")
    public List<commande> getCommandesByClient(@PathVariable Integer id){
        return this.CommandeService.getCommandesByClient( id );
    }
    @GetMapping("/by-date")
    public List<commande> findByDateBetween(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return CommandeService.getCommandesByDateRange(startDate, endDate);
    }

    @PostMapping("/add")
    public void createCommande(@RequestBody commande commande) {
        this.CommandeService.createCommande( commande );
    }

    @PutMapping("/update")
    public void updateCommande( @RequestBody commande commande) {
       this.createCommande( commande );

    }

    @DeleteMapping("/del/{id}")
    public void deleteCommande(@PathVariable Integer id) {
        this.CommandeService.deleteCommande(id);


    }
}
