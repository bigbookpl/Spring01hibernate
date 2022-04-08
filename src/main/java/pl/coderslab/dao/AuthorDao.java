package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public Author add(Author Author) {
        entityManager.persist(Author);
        return Author;
    }

    public Author update(Author Author) {
        entityManager.merge(Author);
        return Author;
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void remove(long id) {
        entityManager.remove(findById(id));
    }

    public List<Author> findAll(){
        return entityManager.createQuery("select b from Author b").getResultList();
    }

}
