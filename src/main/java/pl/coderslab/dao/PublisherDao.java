package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public Publisher add(Publisher publisher) {
        entityManager.persist(publisher);
        return publisher;
    }

    public Publisher update(Publisher publisher) {
        entityManager.merge(publisher);
        return publisher;
    }

    public void remove(long id) {
        entityManager.remove(findById(id));
    }


    public Publisher findById(long id){
        return entityManager.find(Publisher.class, id);
    }

    public List<Publisher> findAll() {
        return entityManager.createQuery("select p from Publisher p").getResultList();
    }
}
