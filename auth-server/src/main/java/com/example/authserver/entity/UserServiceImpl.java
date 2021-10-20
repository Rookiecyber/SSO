package com.example.authserver.entity;


import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Boolean login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if ("admin".equals(username)&&"123".equals(password)){
            return  true;
        }else{
            return false;
        }

    }
}
