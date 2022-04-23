package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitle2(@Param("title") String title);

    @Query("select b from Book b where b.category = :category")
    List<Book> findByCategory2(@Param("category") Category category);


    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long id);
    //piersza książka od końca wg. tytułu w kategorii

    List<Book> findByAuthorsContaining(Author author);
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByRating(Long rating);

    List<Book> findFirstByCategoryOOrderByTitle(Category category);
}