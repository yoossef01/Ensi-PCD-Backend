package com.ensi.PCD.Services;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//


import com.ensi.PCD.Dao.categoryRepository;
import com.ensi.PCD.model.category;
import com.ensi.PCD.model.product;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class categoryServices implements categoryInterfaceService {
 private categoryRepository cc;

 public category save(category c) {
     return this.cc.save(c);
 }

 public List<category> getAllCategories() {
     return this.cc.findAll();
 }
public List<category> getAllCategoriesByVendeur(Integer id){return  this.cc.getCategoriesByVendeur( id );}
 public void deleteCategorie(Integer i) {
     category c = this.getCategory(i);
     this.cc.delete(c);
 }

 public category getCategory(Integer idc) {
     return this.cc.findById(idc).get();
 }

 public categoryServices(final categoryRepository cc) {
     this.cc = cc;
 }

}

