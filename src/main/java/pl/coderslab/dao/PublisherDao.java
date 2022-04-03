package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public Publisher addPublisher(Publisher publisher) {
        entityManager.persist(publisher);
        return publisher;
    }

    public Publisher getById(long id){
        return entityManager.find(Publisher.class, id);
    }

}