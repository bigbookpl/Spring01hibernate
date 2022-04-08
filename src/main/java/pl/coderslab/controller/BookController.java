package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @RequestMapping("/add")
    @ResponseBody
    public String addBook(){
        Book book = new Book();
        Publisher publisher = publisherDao.findById(1L);
        book.setPublisher(publisher);
        book.setTitle("Some title");
        book.setDescription("Some description");
        book.setRating(1);

        Author author1 = authorDao.findById(1L);
        Author author2 = authorDao.findById(2L);

        List<Author> authors = Arrays.asList(author1, author2);
        book.setAuthors(authors);

        bookDao.add(book);

        return "Book Added";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String editBook(){
        Book book = bookDao.findById(1);
        book.setRating(4);
        bookDao.update(book);

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
        Book book = bookDao.findById(1);

        return book.getTitle();
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("books", bookDao.findAll());

        return "books-list";
    }

}
