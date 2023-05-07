package com.ensi.PCD.Services;

import com.ensi.PCD.Dao.UserRepository;
import com.ensi.PCD.Dao.VendeurRepository;
import com.ensi.PCD.model.*;
import com.ensi.PCD.token.TokenVendeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendeurService implements VendeurInterfaceService{
    @Autowired
    private VendeurRepository vendeurRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Vendeur getVendeurById(Integer id) {
       return this.vendeurRepository.findById(id).get();
    }

    @Override
    public List<Vendeur> getAllVendeur() {
        return this.vendeurRepository.findAll();
    }

    @Override
    public Vendeur getVendeurByNomboutique(String nomboutique) {
        return this.vendeurRepository.findByNomboutique(nomboutique).get();
    }



    @Override
    public List<Vendeur> getAllVendeurs(){return this.vendeurRepository.findAll();}
    @Override
    public Vendeur getVendeurByEmail(String email){return this.vendeurRepository.findByEmail( email ).get();}

    @Override
    public void SaveVendeur(Vendeur v) {
        this.vendeurRepository.save(v);
    }

    @Override
    public void DeleteVendeur(Integer id) {
        Vendeur i = this.getVendeurById(id);
        this.vendeurRepository.delete(i);
    }

    @Override
    public Client getClientById(Integer id) {
        return this.userRepository.findById(id).get();
    }
    @Override
    public Client getClientByEmail(String email){return this.userRepository.findByEmail( email ).get();}

    @Override
    public void SaveClient(Client c) {
        this.userRepository.save(c);
    }
}
