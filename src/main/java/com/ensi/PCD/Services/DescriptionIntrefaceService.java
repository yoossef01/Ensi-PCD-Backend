package com.ensi.PCD.Services;

import com.ensi.PCD.model.Description;

import java.util.List;

public interface DescriptionIntrefaceService {
     void saveDescription(Description D);
    void createDescription(Description D);
    Description getDescriptionById(String Id);
    List<Description> getAllDescription();

}
