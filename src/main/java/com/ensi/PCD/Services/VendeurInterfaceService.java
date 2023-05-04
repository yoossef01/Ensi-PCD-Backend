package com.ensi.PCD.Services;

import com.ensi.PCD.model.Client;
import com.ensi.PCD.model.Vendeur;

import java.util.List;

public interface VendeurInterfaceService {
    public Vendeur getVendeurById(Integer id);

    List<Vendeur> getAllVendeur();

    Vendeur getVendeurByEmail(String email);

    Client getClientByEmail(String email);

    public void SaveVendeur(Vendeur v);

    void DeleteVendeur(Integer id);

    public Client getClientById(Integer id);

    void SaveClient(Client c);
}
