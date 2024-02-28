package com.spring.graphq.controller;

import com.spring.graphq.CustomException;
import com.spring.graphq.filter.SearchCriteria;
import com.spring.graphq.model.Book;
import com.spring.graphq.service.BookService;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@WebServlet(urlPatterns = "/graphql-1")
public class BookGraphQlController {

    private final BookService bookService;

    public BookGraphQlController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping("allBooks")
    public List<Book> getAllBook(){
//        try{
//            int x=1/0;
//        }catch (Exception e){
//            throw new CustomException().resolveException()
//        }
        return bookService.getBooks();
    }

    @QueryMapping("createBook")
    public Book createBook(@Argument Book book){
        return bookService.create(book);
    }

    @QueryMapping("getBook")
    public Book getById(@Argument int id){
        return bookService.getBookById(id);
    }

    @QueryMapping("getBookByCriteria")
    public List<Book> getBookByCriteria(@Argument List<SearchCriteria> searchBuilder) throws Exception {
        return bookService.getInventoryByCriteria(searchBuilder);
    }

}
