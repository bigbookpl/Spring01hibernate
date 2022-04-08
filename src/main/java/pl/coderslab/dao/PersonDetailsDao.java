package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    EntityManager entityManager;


    public PersonDetails add(PersonDetails personDetails) {
        entityManager.persist(personDetails);
        return personDetails;
    }

    public PersonDetails update(PersonDetails personDetails) {
        entityManager.merge(personDetails);
        return personDetails;
    }

    public void remove(long id) {
        entityManager.remove(findById(id));
    }


    public PersonDetails findById(long id){
        return entityManager.find(PersonDetails.class, id);
    }

    public List<PersonDetails> findAll() {
        return entityManager.createQuery("select p from PersonDetails p").getResultList();
    }
}
