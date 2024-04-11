package controller;

import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // <html> tag 를 이용해서 응답 코드 작성

        // 1~10 까지의 총합이??
        int hap = MyService.hap();

        // 응답 시 한글 깨집 처리
        resp.setContentType("text/html;charset=UTF-8");

        // 클라이언트에 응답할 출력 스트림(빨대)을 만들어야 한다.
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>총합</td>");
        out.println("<td>" + hap + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
