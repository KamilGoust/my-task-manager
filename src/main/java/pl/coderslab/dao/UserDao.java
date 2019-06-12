package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> allUser() {
        Query query = entityManager.createQuery("SELECT a FROM User a");
        return query.getResultList();
    }
}
