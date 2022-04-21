package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "add-book-form";
    }

    @PostMapping("/add")
    public String saveBook(@ModelAttribute("book") Book book){
        bookDao.add(book);
        return "redirect:/book/list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "add-book-form";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@ModelAttribute("book") Book book){
        bookDao.update(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Long id){
        bookDao.remove(id);
        return "redirect:/book/list";
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


    @ModelAttribute("publishers")
    public List<Publisher> publisher(){
        return publisherDao.findAll();
    }
}
