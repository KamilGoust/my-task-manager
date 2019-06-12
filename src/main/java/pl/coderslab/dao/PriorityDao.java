package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Priority;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PriorityDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Priority> allPriority() {
        Query query = entityManager.createQuery("SELECT a FROM Priority a");
        return query.getResultList();
    }

}
