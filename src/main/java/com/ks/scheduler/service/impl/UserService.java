package com.ks.scheduler.service.impl;

import com.ks.scheduler.entity.User;
import com.ks.scheduler.repository.UserRepository;
import com.ks.scheduler.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findById(int theId) {
        return userRepository.findById ( theId );
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void  deleteById(int theId) {
        userRepository.deleteById(theId);
    }


}
