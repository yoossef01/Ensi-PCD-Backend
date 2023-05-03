package com.ensi.PCD.Services;

import com.ensi.PCD.model.Achat;

import java.util.List;

public interface AchatInterfaceService {
    void saveAchat (Achat achat);

    List<Achat> getallAchat ();
    Achat getAchatById(Integer achatId);
    List<Achat> getAchatByVendeur(Integer vendeurId);
    void createAchat(Achat achat);

}
