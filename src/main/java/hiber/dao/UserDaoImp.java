package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);

   }

   @Override

   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<?> listcars(String string) {
//      Session session = sessionFactory.openSession();
//      session.beginTransaction();
      List<User>users = sessionFactory.getCurrentSession().createQuery("from User").list();
      users.stream().filter(user -> user.getCar().getModel().equals(string)).forEach(System.out::println);
//      session.getTransaction().commit();
//      session.close();
      return users;
   }

   @Override
   public List<?> listcars2(int stringint) {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      List<User>users = session.createQuery("from User").list();
      users.stream().filter(user -> user.getCar().getSeries()== stringint).forEach(System.out::println);
      session.getTransaction().commit();
      session.close();
      return users;
   }

}
