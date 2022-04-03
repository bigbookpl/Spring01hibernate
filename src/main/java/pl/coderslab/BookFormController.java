package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Controller
public class BookFormController {

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @RequestMapping("/add-book")
    public String showBookForm(Model model){

        model.addAttribute("book", new Book());

        return "add-book-form";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    @ResponseBody
    public String saveBookForm(Book book){

        bookDao.addBook(book);

        return "Book was added "+book.getId();
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers(){
        return publisherDao.getAll();
    }

}
