package com.ensi.PCD.Services;
import com.ensi.PCD.Dao.commandeRepository;
import com.ensi.PCD.model.commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service

public class commandeServices {
    @Autowired
    private commandeRepository commandeRepository;
public  void saveCommande(commande commande){

    this.commandeRepository.save( commande );
}
    // method to create a new achat
    public void createCommande(commande commande) {
         this.saveCommande( commande );
    }

    // method to update an existing achat
    //blic void updateAchat(String id,achat achat) {
       //this.saveAchat(  achat)}

    // method to delete an achat by ID
    public void deleteCommande(Integer achatId) {
        commandeRepository.deleteById(achatId);
    }

    // method to get a list of all achats
    public List<commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // method to get an achat by ID
    public commande getCommandeById(Integer achatId) {
        return commandeRepository.findById(achatId).orElse(null);
    }

    // method to get a list of achats within a certain date range
    public List<commande> getCommandesByDateRange(Date startDate, Date endDate) {
        return commandeRepository.findByDateBetween(startDate, endDate);
    }
    public commandeServices(final commandeRepository ar) {
        this.commandeRepository = ar;
    }
    public List<commande> getCommandesByClient(Integer id) {
        return this.commandeRepository.getCommandesByClient( id );
    }


}

