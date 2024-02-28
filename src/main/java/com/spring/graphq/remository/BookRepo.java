package com.spring.graphq.remository;

import com.spring.graphq.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {

}
