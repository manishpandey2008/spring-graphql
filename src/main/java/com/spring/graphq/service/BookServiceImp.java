package com.spring.graphq.service;

import com.spring.graphq.filter.DoFilter;
import com.spring.graphq.filter.SearchCriteria;
import com.spring.graphq.model.Book;
import com.spring.graphq.remository.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookService{

    private final BookRepo bookRepo;

    private Logger logger= LoggerFactory.getLogger(BookServiceImp.class);

    public BookServiceImp(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookRepo.saveAndFlush(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public List<Book> getInventoryByCriteria(List<SearchCriteria> searchBuilder) {
        logger.info("Entered into InventoryServiceV2.getInventoryByCriteria");
        try {
            List<Book> bookList = bookRepo.findAll(DoFilter.getSpecificationWithOperation(searchBuilder,null), Sort.by(Sort.Direction.DESC,"createdTimestamp"));
            return bookList;
        }
        catch (Exception ex) {
            logger.error("Something went wrong during Inventory, error is: "+ ex.getMessage());
        }
        logger.info("Exited from InventoryServiceV2.getStorageLocationByCriteria");
        return new ArrayList<>();
    }
}
