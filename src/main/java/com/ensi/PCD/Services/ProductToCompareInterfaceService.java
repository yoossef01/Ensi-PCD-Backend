package com.ensi.PCD.Services;

import com.ensi.PCD.model.ProductToCompare;

import java.util.List;

public interface ProductToCompareInterfaceService {
    public void save(ProductToCompare p);
    public void delete(Integer id);
    public List<ProductToCompare> getAllProductToComparesByClient(Integer id);
    public void createProductToCompare(ProductToCompare p);
}
