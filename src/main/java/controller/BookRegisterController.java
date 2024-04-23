package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class BookRegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // title, price, author, page : form parameter -> (받아서 DTO 에 담아) : parameter 수집
        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        String author = req.getParameter("author");
        int page = Integer.parseInt(req.getParameter("page"));

        Book book = new Book();
        book.setTitle(title);
        book.setPrice(price);
        book.setAuthor(author);
        book.setPage(page);

        BookDAO bookDAO = new BookDAO();
        int cnt = bookDAO.save(book);
    }
}
