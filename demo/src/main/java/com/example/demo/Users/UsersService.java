package com.example.demo.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
    public Users getUserById(Long id) {
        return usersRepository.findById(id).get();
    }


    public Users register(Users user) {
        if(usersRepository.findFirstByEmail(user.getEmail()) != null){
            return null;
        }
        usersRepository.save(user);
        return user;
    }

    public Users verify(String email, String password) {
        Users user = usersRepository.findFirstByEmail(email);
        if(user == null) {
            return null;
        }
        if(!user.getHashedPassword().equals(password)) {
            return null;
        }
        return user;
    }


}
