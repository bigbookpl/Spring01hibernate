package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long id);
    //piersza książka od końca wg. tytułu w kategorii

    List<Book> findByAuthorsContaining(Author author);
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByRating(Long rating);

    List<Book> findFirstByCategoryOOrderByTitle(Category category);
//    Listę książek dla zadanego autora.
//    Listę książek dla zadanego wydawcy
//    Listę książek dla określonego ratingu
//    Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
}