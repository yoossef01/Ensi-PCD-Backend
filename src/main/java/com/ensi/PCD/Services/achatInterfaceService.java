package com.ensi.PCD.Services;

import com.ensi.PCD.model.achat;

import java.util.Date;
import java.util.List;

public interface achatInterfaceService {
    achat createAchat(achat achat);
   void saveAchat(achat achat);
    achat updateAchat(achat achat);
    void deleteAchat(String achatId);
    List<achat> getAllAchats();
    achat getAchatById(String achatId);
    List<achat> getAchatsByDateRange(Date startDate, Date endDate);

}
