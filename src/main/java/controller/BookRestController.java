package controller;

import entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.BookMapper;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class BookRestController {

    private final BookMapper mapper;

    @GetMapping(path = "/books")
    public ResponseEntity<?> findAll() {
        List<Book> list = mapper.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping(path = "/books/{num}")
    public ResponseEntity<?> delete(@PathVariable int num) {
        mapper.bookDelete(num);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));

        return new ResponseEntity<>("success", headers, HttpStatus.OK);
    }

    @PostMapping(path = "/books")
    public ResponseEntity<?> save(@RequestBody Book book) {
        int cnt = mapper.save(book);

        return new ResponseEntity<>(cnt, HttpStatus.OK);
    }

    @GetMapping(path = "/books/{num}")
    public ResponseEntity<?> getByNum(@PathVariable int num) {
        Book book = mapper.getByNum(num);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping(path = "/books/{num}")
    public ResponseEntity<?> update(@PathVariable int num, @RequestBody Book book) {
//        book.setNum(num);
        mapper.bookUpdate(num, book);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
