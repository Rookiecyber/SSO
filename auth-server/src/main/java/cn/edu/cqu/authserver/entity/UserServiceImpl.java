package cn.edu.cqu.authserver.entity;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if ("admin".equals(username)&&"123".equals(password)){
            return  true;
        }else{
            return false;
        }

    }
    @Override
    public List<User> getList()
    {
        User user1 = new User("u1","123");
        User user2 = new User("u2","123");
        User user3 = new User("u3","123");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return  userList;
    }
}
