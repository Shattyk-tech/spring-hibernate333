package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<?>listcars (String string) ;
    List<?>listcars2 (int stringint) ;
}

