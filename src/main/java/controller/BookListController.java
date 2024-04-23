package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/bookList")
public class BookListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Database 에서 책목록 가져오기 : List -> ArrayList
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.findAll();
//        List<Book> list = new ArrayList<>();
//        list.add(new Book(1, "Java1", 12000, "Hong", 500));
//        list.add(new Book(2, "Java2", 13000, "Park", 600));
//        list.add(new Book(3, "Java3", 14000, "Lee", 700));
//        list.add(new Book(4, "Spring1", 25000, "Kim", 250));
//        list.add(new Book(5, "Spring2", 15000, "Lee", 300));

        // 가격 비싼 순 정렬
        Collections.sort(books, (o1, o2) -> o2.getPrice() - o1.getPrice());

        // 객체 바인딩
        req.setAttribute("list", books);

        // View(JSP) 와 연동하기(forward, dispatcher)
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(req, resp);

    }
}
