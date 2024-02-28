package com.spring.graphq.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String desc;
    private String author;
    private double price;
    private int page;
    private Date createdTimestamp=new Date();

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "topic_id", referencedColumnName = "id")
//    private List<Topic> topics=new ArrayList<>();
}
