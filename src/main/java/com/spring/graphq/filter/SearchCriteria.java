package com.spring.graphq.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria implements Serializable {
    private String fieldName;
    private String operation;
    private String value;
}
