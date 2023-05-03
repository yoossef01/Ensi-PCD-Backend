package com.ensi.PCD.controllers;

import com.ensi.PCD.Services.AchatService;
import com.ensi.PCD.model.Achat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apiachat"})
public class AchatController {
    @Autowired
    AchatService achatService;
    @GetMapping({"/all"})
    public List<Achat> getallAchat(){
        return this.achatService.getallAchat();
    }
    @PostMapping({"/save"})
    public void saveAchat(@RequestBody Achat achat) {
        this.achatService.createAchat(achat);
    }
    @GetMapping({"/achatById/{id}"})
    public Achat getachatById(@PathVariable Integer id) {
        return this.achatService.getAchatById(id);
    }
    @GetMapping({"/achatByVendeur/{id}"})
    public List<Achat> getachatByVendeur(@PathVariable Integer id) {
        return this.achatService.getAchatByVendeur(id);
    }


}
