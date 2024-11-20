package com.ks.scheduler.service.impl;

import com.ks.scheduler.entity.User;
import com.ks.scheduler.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
  private UserService userService;
    @Mock
    private UserRepository userRepository;

    private User person1;
    private User person2;

    @BeforeEach
    void init(){

        person1=new User();
        person1.setId(10);
        person1.setFirstName("John");
        person1.setLastName("Smith");
        person1.setEmail("j@gmail.com");

      person2=new User();
        person2.setId(11);
        person2.setFirstName("Tom");
        person2.setLastName("Lincon");
        person2.setEmail("T@gmail.com");
    }


    @Test
    void save() {
        //Arrange

        //any(User.class means any object created from user.class
        when(userRepository.save(any(User.class))).thenReturn(person1);
        //Act
        User MockedPerson=userService.save(person1);
        //Assertions
        assertThat(MockedPerson.getFirstName()).isEqualTo("John");
        assertNotNull(MockedPerson);
    }

    @Test
    void findById() {

        when(userRepository.findById (person1.getId())).thenReturn(Optional.of(person1));
      Optional<User>  mockedById= userService.findById(person1.getId());
        assertNotNull(mockedById);
    }

    @Test
    void findAll() {

        List<User> list1=new ArrayList<>();
        list1.add(person1);
        list1.add(person2);
        //Act
        when(userRepository.findAll()).thenReturn(list1);
        List<User> mockedAllList=userService.findAll();
        //Assert
        assertEquals(2,list1.size());
    }


}