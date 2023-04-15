package com.ensi.PCD.Services;

import com.ensi.PCD.model.Client;
import com.ensi.PCD.model.Vendeur;

public interface VendeurInterfaceService {
    public Vendeur getVendeurById(Integer id);
    public void SaveVendeur(Vendeur v);

    public Client getClientById(Integer id);
}
