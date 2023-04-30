package com.ensi.PCD.Services;

import com.ensi.PCD.Dao.UserRepository;
import com.ensi.PCD.Dao.VendeurRepository;
import com.ensi.PCD.model.Client;
import com.ensi.PCD.model.Vendeur;
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
    public List<Vendeur> getAllVendeurs(){return this.vendeurRepository.findAll();}
    @Override
    public Vendeur getVendeurByEmail(String email){return this.vendeurRepository.findByEmail( email ).get();}

    @Override
    public void SaveVendeur(Vendeur v) {
        this.vendeurRepository.save(v);
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
