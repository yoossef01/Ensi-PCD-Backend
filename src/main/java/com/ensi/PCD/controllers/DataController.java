package com.ensi.PCD.controllers;


import com.ensi.PCD.Services.DataService;
import com.ensi.PCD.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/api"})
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping({"/data"})
    public List<Data> getAllData() {
        return this.dataService.getAllData();
    }
}
