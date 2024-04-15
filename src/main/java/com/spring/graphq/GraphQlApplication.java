package com.spring.graphq;

import com.spring.graphq.model.Book;
import com.spring.graphq.model.Topic;
import com.spring.graphq.remository.TopicRepo;
import com.spring.graphq.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GraphQlApplication  implements CommandLineRunner {

//	https://www.danvega.dev/blog/graphql-mutations

//	private final BookService bookService;
//	private final TopicRepo topicRepo;
//
//	private final Logger logger= LoggerFactory.getLogger(GraphQlApplication.class);
//
//	public GraphQlApplication(BookService bookService, TopicRepo topicRepo) {
//		this.bookService = bookService;
//		this.topicRepo = topicRepo;
//	}


	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		bookService.create(
//				new Book(1,"Making India Awesome","This is for Book 1","Chetan Bhagat",76.44,23,new Date())
//		);
//		bookService.create(
//				new Book(2,"One Indian Girl","This is for Book 2","Chetan Bhagat",876.23,45,new Date())
//				);
//		bookService.create(
//				new Book(3,"A Million Mutinies Now","This is for Book 3","V.S. Naipaul",98.34,12,new Date())
//				);
//		bookService.create(
//				new Book(4,"All the Prime Minister’s Men ","This is for Book 4","Janardan Thakur",87.23,983,new Date())
//		);
		System.out.println("-----------------------Dummy data added---------------------------");
	}
}
