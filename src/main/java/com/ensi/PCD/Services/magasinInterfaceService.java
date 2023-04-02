package com.ensi.PCD.Services;

import com.ensi.PCD.model.magasin;

import java.util.List;

public interface magasinInterfaceService {
    List<magasin> getAllMagasins();

    magasin save(magasin m);

    void deleteMagasin(Integer i);

    magasin getMagasin(Integer idm);
}
