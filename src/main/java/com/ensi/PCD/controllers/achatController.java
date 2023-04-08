package com.ensi.PCD.controllers;
import com.ensi.PCD.Services.achatServices;
import com.ensi.PCD.model.achat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.net.URI;
import java.util.Date;
import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apiachat"})
public class achatController {
    @Autowired
    private achatServices achatService;

    @GetMapping("/{id}")
    public ResponseEntity<achat> findById(@PathVariable String id) {
        achat achat = achatService.getAchatById(id);
        if (achat != null) {
            return ResponseEntity.ok(achat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping({"/all"})
    public List<achat> getAllAchats() {
        return this.achatService.getAllAchats();
    }
    @GetMapping("/by-date")
    public List<achat> findByDateBetween(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                         @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return achatService.getAchatsByDateRange(startDate, endDate);
    }

    @PostMapping("/add")
    public void createAchat(@RequestBody achat achat) {
        this.achatService.createAchat(achat);
    }

    @PutMapping("/update")
    public void updateAchat( @RequestBody achat achat) {
       this.createAchat(achat);

    }

    @DeleteMapping("/del/{id}")
    public void deleteAchat(@PathVariable String id) {
        this.achatService.deleteAchat(id);


    }
}
