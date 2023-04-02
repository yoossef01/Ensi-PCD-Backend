package com.ensi.PCD.controllers;


import com.ensi.PCD.Dao.magasinRepository;
import com.ensi.PCD.Services.magasinServices;
import com.ensi.PCD.model.magasin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apimagasin"})
public class magasinController {
    magasinServices ms;
    private final com.ensi.PCD.Dao.magasinRepository magasinRepository;

    public magasinController(magasinServices ms,
                            magasinRepository magasinRepository) {
        this.ms= ms;
        this.magasinRepository = magasinRepository;
    }

    @GetMapping({"/all"})
    public List<magasin> getAllMagasins() {
        return this.ms.getAllMagasins();
    }

    @PostMapping({"/add"})
    public magasin ajouterMagasin(@RequestBody magasin m) {
        magasin newMagasin = this.ms.save(m);
        return newMagasin;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity< magasin> modifierMagasin(@PathVariable Integer id, @RequestBody  magasin  magasinModifiee) {
        Optional< magasin>  magasinOptional =  magasinRepository.findById(id);

        if (! magasinOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        magasin magasinExistante = magasinOptional.get();
        magasinExistante.setNom( magasinModifiee.getNom());

        magasin  magasinMiseAJour =  magasinRepository.save( magasinExistante);
        return ResponseEntity.ok( magasinMiseAJour);
    }

    @DeleteMapping({"/del/{id}"})
    public void supprimerMgasin(@PathVariable Integer id) {
        this.ms.deleteMagasin(id);
    }

    @GetMapping({"/ magasinById/{id}"})
    public  magasin getMagasin(@PathVariable Integer id) {
        return this.ms.getMagasin(id);
    }
}
