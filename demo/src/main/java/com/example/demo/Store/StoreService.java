package com.example.demo.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).get();
    }

    public List<Store> getStoreByName(String name) {
        return storeRepository.findByName(name);
    }
    public Store getStoreByManagerId(Long id) {return storeRepository.findFirstByManager_Id(id);}
}
