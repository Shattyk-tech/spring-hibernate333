package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   List<?>listcars (String string) ;
   List<?>listcars2 (int stringint) ;
}

