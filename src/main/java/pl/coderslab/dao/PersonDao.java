package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;


    public Person add(Person person) {
        entityManager.persist(person);
        return person;
    }

    public Person update(Person person) {
        entityManager.merge(person);
        return person;
    }

    public void remove(long id) {
        entityManager.remove(findById(id));
    }


    public Person findById(long id){
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll() {
        return entityManager.createQuery("select p from Person p").getResultList();
    }
}
