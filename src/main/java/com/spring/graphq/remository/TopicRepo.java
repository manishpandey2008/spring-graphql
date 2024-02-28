package com.spring.graphq.remository;

import com.spring.graphq.model.Book;
import com.spring.graphq.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TopicRepo extends JpaRepository<Topic,Long> {
}
