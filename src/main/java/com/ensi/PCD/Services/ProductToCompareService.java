package com.ensi.PCD.Services;

import com.ensi.PCD.Dao.ProductToCompareRepository;
import com.ensi.PCD.Dao.productRepository;
import com.ensi.PCD.model.ProductToCompare;
import com.ensi.PCD.model.commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductToCompareService implements ProductToCompareInterfaceService {
    @Autowired
    private ProductToCompareRepository pr;
@Override
    public void save(ProductToCompare p){
        this.pr.save(p);
    }
    @Override
    public void createProductToCompare(ProductToCompare p) {
        this.save( p );
    }
    @Override

    public void delete(Integer id){
        this.pr.deleteById( id );
    }
    @Override

    public List<ProductToCompare> getAllProductToComparesByClient(Integer id){
        return this.pr.getAllProductToComparesByClient(id);
    }
    public ProductToCompareService(final ProductToCompareRepository pr) {
        this.pr = pr;
    }
}
