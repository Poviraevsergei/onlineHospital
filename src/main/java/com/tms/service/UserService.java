package com.tms.service;

import com.tms.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void getUser(int id){
        System.out.println("UserService working... getUser method! With id = " + id);
        //  идём через JDBC в базу и возращаем нужного юзера!
    }

    public User createUser(int id, String firstname){
        User user = new User();
        user.setId(id);
        user.setFirstName(firstname);
        //Тут мы через JDBC должны класть в БД
        return user;
    }
}
