package com.ks.scheduler.service;

import com.ks.scheduler.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {

    User newUser(User newUser);

    Optional<User> findById(int theId);
}
