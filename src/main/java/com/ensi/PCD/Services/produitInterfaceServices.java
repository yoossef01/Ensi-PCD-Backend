package com.ensi.PCD.Services;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//


import com.ensi.PCD.model.product;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface produitInterfaceServices {
 void saveProduct(product p, MultipartFile mf);

 String UploadPhoto(MultipartFile mf);

 byte[] getImage(String idproduit);

 List<product> getAllProducts();

 product getProduit(String idProduct);

 List<product> getProductsByCat(Integer idcat);

 void deleteProduct(String idp);
}

