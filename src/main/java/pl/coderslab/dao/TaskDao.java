package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class TaskDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Task entity) {
        entityManager.persist(entity);
    }

    public Task findById(long id) {
        return entityManager.find(Task.class, id);
    }

    public void update(Task entity) {
        entityManager.merge(entity);
    }

    public void delete(Task entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Task> allTask() {
        Query query = entityManager.createQuery("SELECT a FROM Task a");
        return query.getResultList();
    }
}
