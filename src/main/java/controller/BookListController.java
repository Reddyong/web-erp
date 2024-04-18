package controller;

import entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bookList")
public class BookListController extends HttpServlet {
    // GET -> doGet()
    // POST -> doPost()
    // GET, POST -> service()
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Database 에서 책목록 가져오기 : List -> ArrayList
        List<Book> list = new ArrayList<>();
        list.add(new Book(1, "Java1", 12000, "Hong", 500));
        list.add(new Book(2, "Java2", 13000, "Park", 600));
        list.add(new Book(3, "Java3", 14000, "Lee", 700));

        // 객체 바인딩
        req.setAttribute("list", list);

        // View(JSP) 와 연동하기(forward, dispatcher)
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(req, resp);

    }
}
