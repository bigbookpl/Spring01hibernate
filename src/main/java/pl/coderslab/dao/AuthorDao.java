package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public Author addAuthor(Author Author) {
        entityManager.persist(Author);
        return Author;
    }

    public Author editAuthor(Author Author) {
        entityManager.merge(Author);
        return Author;
    }

    public Author getById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void remove(long id) {
        entityManager.remove(getById(id));
    }

    public List<Author> findAll(){
        return entityManager.createQuery("select b from Author b").getResultList();
    }

}
