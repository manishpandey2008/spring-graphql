package com.spring.graphq.controller;

import com.spring.graphq.filter.SearchCriteria;
import com.spring.graphq.model.Book;
import com.spring.graphq.service.BookServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookServiceImp bookService;

    public BookController(BookServiceImp bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> getAllBook(){
        return bookService.getBooks();
    }

    @PostMapping
    Book addBook(@RequestBody Book book){
        return  bookService.create(book);
    }

    @GetMapping("/{id}")
    Book getBookById(@PathVariable("id") long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/get-book-by-criteria")
    public List<Book> getBookByCriteria(@RequestBody List<SearchCriteria> searchBuilder,
                                        @RequestParam("page") Integer page,
                                        @RequestParam("size") Integer size) throws Exception {
       return bookService.getInventoryByCriteria(searchBuilder);
    }
}
