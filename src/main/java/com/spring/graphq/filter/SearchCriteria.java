package com.spring.graphq.filter;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SearchCriteria {
    private String fieldName;
    private String operation;
    private String value;

}
