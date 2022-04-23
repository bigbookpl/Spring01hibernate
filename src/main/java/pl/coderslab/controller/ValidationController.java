package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collections;
import java.util.Set;

@Controller
@RequestMapping("/validate")
public class ValidationController {


    @Autowired
    private Validator validator;

    @Autowired
    private BookDao bookDao;

    @RequestMapping("/book")
    @ResponseBody
    public String validateBook(){
        Book book = new Book();
        book.setPages(1);
        book.setAuthors(Collections.emptyList());

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        if (violations.isEmpty()){
            bookDao.add(book);
        }else {
            for (ConstraintViolation<Book> violation : violations) {
                System.out.println(violation.getPropertyPath()+" ----> "+violation.getMessage());
            }
        }
        return "validation";
    }

}
