package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        Publisher publisher = new Publisher();
        publisher.setName("Example name");
        return "Publisher added";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(){
        Publisher publisher  = publisherDao.findById(1);
        publisher.setName("Example name 2");
        publisherDao.update(publisher);

        return "Publisher updated";
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String remove(){
        publisherDao.remove(1L);

        return "Publisher removed";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find(){
        Publisher publisher = publisherDao.findById(1);

        return publisher.getName();
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("publishers", publisherDao.findAll());

        return "publisher-list";
    }

}
