package com.ensi.PCD.Services;

import com.ensi.PCD.Dao.DataRepository;
import com.ensi.PCD.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataService implements DataInterfaceService {
    @Autowired
    private DataRepository dataRepository;
    @Override
    public List<Data> getAllData() {
        return this.dataRepository.findAll();
    }
}
