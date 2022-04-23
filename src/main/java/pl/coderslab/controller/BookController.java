package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

//    @Autowired
//    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "add-book-form";
    }

    @PostMapping("/add")
    public String saveBookForm(@Valid Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "add-book-form";
        }

        bookRepository.save(book);
        return "redirect:/book/list";
    }


    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
        Optional<Book> book = bookRepository.findById(id);
        model.addAttribute("book", book);
        return "add-book-form";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@ModelAttribute("book") Book book){
        bookRepository.save(book);


        return "redirect:/book/list";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
        return "redirect:/book/list";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String findBook(){
        Optional<Book> book = bookRepository.findById(1L);

        return book.get().getTitle();
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("books", bookRepository.findAll());

        return "books-list";
    }


    @ModelAttribute("publishers")
    public List<Publisher> publisher(){
        return publisherDao.findAll();
    }
}
