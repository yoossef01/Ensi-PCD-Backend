package com.ensi.PCD.Services;

import com.ensi.PCD.model.commande;

import java.util.Date;
import java.util.List;

public interface commandeInterfaceService {
    commande createCommande(commande commande);
   void saveCommande(commande commande);
    commande updateCommande(commande commande);
    void deleteCommande(String achatId);
    List<commande> getAllCommandes();
    commande getCommandeById(String achatId);
    List<commande> getAchatsByDateRange(Date startDate, Date endDate);

}
