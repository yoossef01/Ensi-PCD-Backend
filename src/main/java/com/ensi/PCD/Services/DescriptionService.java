package com.ensi.PCD.Services;

import com.ensi.PCD.Dao.DescriptionRepository;
import com.ensi.PCD.Dao.categoryRepository;
import com.ensi.PCD.model.Description;
import com.ensi.PCD.model.commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class DescriptionService {
    @Autowired
    private DescriptionRepository DR;

    public void saveDescription(Description D) {
        if (D.getId() == null) {
            D.setId( UUID.randomUUID().toString() );
        }
        this.DR.save( D );
    }

    public void createDescription(Description D) {
        this.saveDescription( D );
    }
    public Description getDescriptionById(String Id) {
        return DR.findById(Id).orElse(null);
    }
    public DescriptionService(final DescriptionRepository DR) {
        this.DR = DR;
    }
    public Description getDescriptionByProduct(String id){
        return this.DR.getDescriptionByProduct( id );
    }

    public List<Description> getAllDescription(){return this.DR.findAll();}
}