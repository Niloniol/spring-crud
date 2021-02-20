package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class, user.getId()));
        entityManager.getTransaction().commit();
    }

    @Override
    public User getById(Long id) {
        return entityManager.getReference(User.class, id);
    }

    @Override
    public void update(User user) {
        if(entityManager.contains(user)) {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }
}
