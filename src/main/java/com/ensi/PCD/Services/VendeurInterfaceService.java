package com.ensi.PCD.Services;

import com.ensi.PCD.model.Client;
import com.ensi.PCD.model.Vendeur;

public interface VendeurInterfaceService {
    public Vendeur getVendeurById(Integer id);

    Vendeur getVendeurByEmail(String email);

    Client getClientByEmail(String email);

    public void SaveVendeur(Vendeur v);

    public Client getClientById(Integer id);

    void SaveClient(Client c);
}