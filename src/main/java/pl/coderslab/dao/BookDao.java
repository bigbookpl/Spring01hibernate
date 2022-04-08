package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public Book add(Book book) {
        entityManager.persist(book);
        return book;
    }

    public Book update(Book book) {
        entityManager.merge(book);
        return book;
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void remove(long id) {
        entityManager.remove(findById(id));
    }

    public List<Book> findAll(){
        return entityManager.createQuery("select b from Book b").getResultList();
    }

    public List<Book> findAllByRating(int rating){
        Query query = entityManager.createQuery("select b from Book b where b.rating = :rating");
        query.setParameter("rating",rating);
        return query.getResultList();
    }

    public List<Book> findAllPublisher(Publisher publisher){
        Query query = entityManager.createQuery("select b from Book b where b.publisher = :publisher");
        query.setParameter("publisher",publisher);
        return query.getResultList();
    }

    public List<Book> findAllAuthor(Author author){
        Query query = entityManager.createQuery("select b from Book b where :author MEMBER of b.authors");
        query.setParameter("author",author);
        return query.getResultList();
    }
}
