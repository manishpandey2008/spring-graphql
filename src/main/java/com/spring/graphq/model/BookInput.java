package com.spring.graphq.model;

import lombok.Data;


@Data
public class BookInput {
    private long id;
    private String title;
    private String desc;
    private String author;
    private double price;
    private int page;
}
