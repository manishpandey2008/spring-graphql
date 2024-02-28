package com.spring.graphq.service;

import com.spring.graphq.filter.SearchCriteria;
import com.spring.graphq.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book create(Book book);

    Book getBookById(long id);

     List<Book> getInventoryByCriteria(List<SearchCriteria> searchBuilder);

}
