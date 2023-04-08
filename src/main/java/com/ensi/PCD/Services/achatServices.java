package com.ensi.PCD.Services;
import com.ensi.PCD.Dao.achatRepository;
import com.ensi.PCD.Dao.productRepository;
import com.ensi.PCD.model.achat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service

public class achatServices {
    @Autowired
    private achatRepository achatRepository;
public  void saveAchat(achat achat){
    if (achat.getId() == null) {
        achat.setId( UUID.randomUUID().toString());

    }
    this.achatRepository.save( achat );
}
    // method to create a new achat
    public void createAchat(achat achat) {
         this.saveAchat(achat);
    }

    // method to update an existing achat
    //blic void updateAchat(String id,achat achat) {
       //this.saveAchat(  achat)}

    // method to delete an achat by ID
    public void deleteAchat(String achatId) {
        achatRepository.deleteById(achatId);
    }

    // method to get a list of all achats
    public List<achat> getAllAchats() {
        return achatRepository.findAll();
    }

    // method to get an achat by ID
    public achat getAchatById(String achatId) {
        return achatRepository.findById(achatId).orElse(null);
    }

    // method to get a list of achats within a certain date range
    public List<achat> getAchatsByDateRange(Date startDate, Date endDate) {
        return achatRepository.findByDateBetween(startDate, endDate);
    }
    public achatServices(final achatRepository ar) {
        this.achatRepository = ar;
    }

}

