package controller;

import entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.BookMapper;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final BookMapper mapper;

    @PostMapping(path = "/login")
    public String login(Member member, HttpSession session) {
        if (member.getUsername().equals("admin") &&
                member.getPassword().equals("admin")) {
            Member dbmem = new Member();
            dbmem.setUsername(member.getUsername());
            dbmem.setName("관리자");
            dbmem.setEmail("bit@aaa.ac.kr");

            session.setAttribute("dbmem", dbmem);
        }

        return "redirect:/bookList";
    }
}
