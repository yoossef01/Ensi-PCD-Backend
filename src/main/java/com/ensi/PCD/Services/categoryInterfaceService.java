package com.ensi.PCD.Services;

import com.ensi.PCD.model.category;
import java.util.List;

public interface categoryInterfaceService {
    List<category> getAllCategories();

    category save(category c);

    void deleteCategorie(Integer i);

    category getCategory(Integer idc);
    List<category> getAllCategoriesByVendeur(Integer id);
}
