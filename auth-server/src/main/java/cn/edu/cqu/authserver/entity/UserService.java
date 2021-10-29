package cn.edu.cqu.authserver.entity;


import java.util.List;

public interface UserService {

    public boolean login(User user);
    public List<User> getList();
}

