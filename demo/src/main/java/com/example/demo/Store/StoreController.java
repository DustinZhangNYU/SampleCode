package com.example.demo.Store;

import com.example.demo.Users.Users;
import com.example.demo.Users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "store")
public class StoreController {
    private final StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @GetMapping(path = "/getAllStores")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }
    @GetMapping(path = "/getStoreById")
    public Store getStoreById(@RequestParam Long id){
        return storeService.getStoreById(id);
    }
    @GetMapping(path = "/getStoreByManagerId")
    public Store getStoreByManagerId(@RequestParam Long id) {return storeService.getStoreByManagerId(id);};
    @GetMapping(path = "/getStoreByName")
    public List<Store> getSoreByName(@RequestParam String name) {
        return storeService.getStoreByName(name);
    }

}
