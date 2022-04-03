package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @RequestMapping("/add")
    @ResponseBody
    public String addBook(){
        Book book = new Book();
        Publisher publisher = publisherDao.getById(1L);
        book.setPublisher(publisher);
        book.setTitle("Some title");
        book.setDescription("Some description");
        book.setRating(1);
        bookDao.addBook(book);

        return "Book Added";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String editBook(){
        Book book = bookDao.getById(1);
        book.setRating(4);
        bookDao.editBook(book);

        return "Book updated";
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String removeBook(){
        bookDao.remove(1L);

        return "Book removed";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String findBook(){
        Book book = bookDao.getById(1);

        return book.getTitle();
    }
}
