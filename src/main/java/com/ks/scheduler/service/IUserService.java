package com.ks.scheduler.service;

import com.ks.scheduler.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {

    User save(User newUser);

    Optional<User> findById(int theId);

    List<User> findAll();

    void deleteById(int theId);
}
