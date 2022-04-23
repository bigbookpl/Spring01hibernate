package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getFirstByEmail(String email);
    Author getFirstByPesel(String pesel);
    Author getFirstByLastName(String lastName);
}
