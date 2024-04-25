package controller;

import entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.BookDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(path = "")
public class BookController {
    @RequestMapping(path = "/bookList", method = RequestMethod.GET)
    public String findAll(Model model) {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.findAll();

        model.addAttribute("list", bookList);

        return "list";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String registerGET() {
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String registerPOST(Book book) {
        BookDAO bookDAO = new BookDAO();
        bookDAO.save(book);

        return "redirect:/bookList";
    }
}
