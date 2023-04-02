package com.ensi.PCD.Services;


import com.ensi.PCD.Dao.magasinRepository;
import com.ensi.PCD.model.magasin;
import com.ensi.PCD.model.product;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class magasinServices  implements magasinInterfaceService {
    private magasinRepository mr;
    public magasin save(magasin m) {
        return this.mr.save(m);
    }

    public List<magasin> getAllMagasins() {
        return this.mr.findAll();
    }

    public void deleteMagasin(Integer i) {
        magasin m = this.getMagasin(i);
        List<product> l = m.getProduits();
        Iterator<product> var5 = l.iterator();

        while(var5.hasNext()) {
            product p = var5.next();
            p.setMagasin(null);
        }

        this.mr.delete(m);
    }

    public magasin getMagasin(Integer idc) {
        return this.mr.findById(idc).get();
    }

    public magasinServices(final magasinRepository mr) {
        this.mr = mr;
    }
}


