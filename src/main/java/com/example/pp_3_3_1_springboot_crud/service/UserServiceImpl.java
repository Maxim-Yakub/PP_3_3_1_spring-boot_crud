package com.example.pp_3_3_1_springboot_crud.service;

import com.example.pp_3_3_1_springboot_crud.model.User;
import com.example.pp_3_3_1_springboot_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final
    UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public void save (User user) {
        repository.save(user);
    }


    public List<User> getAll () {
        return (List<User>) repository.findAll();
    }


    public User get(Long id) {
        return repository.findById(id).get();
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void update(User updatedUser){

        save(updatedUser);
    }

    public List<User> search(String keyword) {
        return repository.search(keyword);
    }
}
