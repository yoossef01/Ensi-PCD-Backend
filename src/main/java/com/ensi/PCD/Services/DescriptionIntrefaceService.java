package com.ensi.PCD.Services;

import com.ensi.PCD.model.Description;

public interface DescriptionIntrefaceService {
     void saveDescription(Description D);
    void createDescription(Description D);
    Description getDescriptionById(String Id);


}