package com.ensi.PCD.Services;

import com.ensi.PCD.Dao.AchatRepository;
import com.ensi.PCD.model.Achat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AchatService implements AchatInterfaceService {
    @Autowired
    private AchatRepository achatRepository;

    @Override
    public void saveAchat(Achat achat) {

        this.achatRepository.save(achat);
    }

    @Override
    public List<Achat> getallAchat() {
        return this.achatRepository.findAll();
    }

    @Override
    public Achat getAchatById(Integer achatId) {
        return (Achat)this.achatRepository.findById(achatId).get();
    }

    @Override
    public List<Achat> getAchatByVendeur(Integer vendeurId) {
        return this.achatRepository.getAchatByVendeur(vendeurId);
    }

    @Override
    public void createAchat(Achat achat) {
        this.saveAchat(achat);
    }
}
