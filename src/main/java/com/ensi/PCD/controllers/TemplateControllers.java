package com.ensi.PCD.controllers;

import com.ensi.PCD.Services.TemplateContentServices;
import com.ensi.PCD.model.TemplateContent;
import com.ensi.PCD.model.product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/apitemplate"})
public class TemplateControllers {
    @Autowired
    private TemplateContentServices templateContentServices;

    @GetMapping("/vendeur/{id}")
    public TemplateContent getTemplateByVend(@PathVariable Integer id){
       return this.templateContentServices.getTemplateByVendeur( id );
    }

    @PostMapping("/add")
    public void createTemplate(@RequestParam(value = "template") String templateContent ,@RequestParam(value = "photo",required = false) MultipartFile mf){
        try {
            TemplateContent t = (TemplateContent)(new ObjectMapper()).readValue(templateContent, TemplateContent.class);
            this.templateContentServices.ajoutTemplate(t, mf);
        } catch (JsonMappingException var4) {
            var4.printStackTrace();
        } catch (JsonProcessingException var5) {
            var5.printStackTrace();
        }
    }
    @PutMapping("/update")
    public void updateTemplate(@RequestParam(value = "template") String templateContent ,@RequestParam(value = "photo",required = false) MultipartFile mf){
        this.createTemplate( templateContent ,mf);
    }
    @GetMapping(
            path = {"/getimage/{id}"},
    produces = {"image/png"}
 )
    public byte[] getImage(@PathVariable Integer id) {
        return this.templateContentServices.getImage(id);
    }
}
