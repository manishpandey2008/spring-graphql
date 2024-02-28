package com.spring.graphq.filter;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.spring.graphq.constant.Status.OR;

@Component
public class DoFilter {
    public static Specification getSpecificationWithOperation(List<SearchCriteria> fieldClassList, String operation) {
        return (Specification) (root, criteriaQuery, criteriaBuilder) -> {

            ArrayList<Predicate> predicates = new ArrayList<>();

            for (SearchCriteria fieldClass : fieldClassList) {

                if (fieldClass.getFieldName() != null && fieldClass.getFieldName().length() > 0) {
                    Object value = fieldClass.getValue();
                    Path path = root.get(fieldClass.getFieldName());
                    Expression upper = null;
                    if (value instanceof String str) {
                        value = str.toUpperCase();
                        upper = criteriaBuilder.upper(path);
                    }
                    if (fieldClass.getOperation().equalsIgnoreCase("equals")) {
                        predicates.add(criteriaBuilder.equal(upper ==null ?path: upper, value));
                    } else if (fieldClass.getOperation().equalsIgnoreCase("equalsOrNull")){
                        criteriaBuilder.or(criteriaBuilder.isNull(path),criteriaBuilder.equal(upper ==null ?path: upper, value));
                    } else if (fieldClass.getOperation().equalsIgnoreCase("notequals")) {
                        predicates.add(criteriaBuilder.notEqual(upper ==null ?path: upper, value));
                    } else if (fieldClass.getOperation().equalsIgnoreCase("contains")) {
                        predicates.add(criteriaBuilder.like(path, "%" + value + "%"));
                    } else if (fieldClass.getOperation().equalsIgnoreCase("in")) {
                        if (fieldClass.getValue() != null) {
                            List<?> list = new ArrayList<>((Collection<?>) fieldClass.getValueList());
                            if (list.size() > 0) {
                                Expression<String> exp = path;
                                Predicate predicate = exp.in(list);
                                predicates.add(predicate);
                            }
                        }
                    }  else if (fieldClass.getOperation().equalsIgnoreCase("inDates")) {
                        if (fieldClass.getValue() != null) {
                            List<?> list = new ArrayList<>((Collection<?>) fieldClass.getValueList());
                            if (list.size() > 0) {
                                Expression<String> exp = path.as(LocalDateTime.class);
                                Predicate predicate = exp.in(list);
                                predicates.add(predicate);
                            }
                        }
                    }
                }
            }
            if (operation == null) {
                return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0]))).getRestriction();
            } else {
                if (operation.equalsIgnoreCase(OR)) {
                    return criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0]))).getRestriction();
                } else {
                    return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0]))).getRestriction();
                }
            }
        };
    }
}
